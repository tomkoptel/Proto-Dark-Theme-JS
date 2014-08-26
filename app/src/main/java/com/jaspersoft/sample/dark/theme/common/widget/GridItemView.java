package com.jaspersoft.sample.dark.theme.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jaspersoft.sample.dark.theme.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.DimensionPixelSizeRes;

@EViewGroup(R.layout.resource_grid_item)
public class GridItemView extends FrameLayout {

    @ViewById(android.R.id.text1)
    protected TextView mTitleTxt;
    @ViewById(android.R.id.text2)
    protected TextView mSubTitle;
    @ViewById(R.id.timestampStub)
    protected ViewStub mTimestampStub;

    protected TextView mTimestampTxt;

    @DimensionPixelSizeRes(R.dimen.grid_item_height)
    protected int mHeight;

    public GridItemView(Context context) {
        this(context, null);
    }

    public GridItemView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.gridLayoutStyle);
    }

    public GridItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @AfterViews
    final void init() {
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT, mHeight);
        setLayoutParams(params);
    }

    public void setTitle(CharSequence title) {
        mTitleTxt.setText(title);
    }

    public void setSubTitle(CharSequence subTitle) {
        if (mSubTitle != null) {
            mSubTitle.setText(subTitle);
        }
    }

    public void setTimeTamp(CharSequence timestamp) {
        if (mTimestampStub != null) {
            if (mTimestampTxt == null) {
                mTimestampTxt = (TextView) mTimestampStub.inflate();
            }
            mTimestampTxt.setText(timestamp);
        }
    }

}
