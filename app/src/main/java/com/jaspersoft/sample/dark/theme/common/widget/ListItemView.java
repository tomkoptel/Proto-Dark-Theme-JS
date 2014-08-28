package com.jaspersoft.sample.dark.theme.common.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaspersoft.sample.dark.theme.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.DimensionPixelSizeRes;

@EViewGroup(R.layout.resource_list_item)
public class ListItemView extends RelativeLayout {

    @ViewById(android.R.id.icon)
    protected ImageView mImageIcon;
    @ViewById(android.R.id.text1)
    protected TextView mTitleTxt;
    @ViewById(android.R.id.text2)
    protected TextView mSubTitle;
    @ViewById(R.id.timestampStub)
    protected ViewStub mTimestampStub;
    @ViewById(R.id.miscStub)
    protected ViewStub mMiscStub;

    protected TextView mTimestampTxt;
    protected TextView mMiscTxt;

    @DimensionPixelSizeRes(R.dimen.list_item_height)
    protected int mHeight;

    public ListItemView(Context context) {
        this(context, null);
    }

    public ListItemView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.listLayoutStyle);
    }

    public ListItemView(Context context, AttributeSet attrs, int defStyle) {
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
        mSubTitle.setText(subTitle);
    }

    public void setTimeTamp(CharSequence timestamp) {
        if (mTimestampStub != null) {
            if (mTimestampTxt == null) {
                mTimestampTxt = (TextView) mTimestampStub.inflate();
            }
            mTimestampTxt.setText(timestamp);

            RelativeLayout.LayoutParams params = (LayoutParams) mTitleTxt.getLayoutParams();
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                params.addRule(START_OF, mTimestampTxt.getId());
            }
            params.addRule(LEFT_OF, mTimestampTxt.getId());
            mTitleTxt.setLayoutParams(params);
        }
    }

    public void setMisc(CharSequence misc) {
        if (mMiscStub != null) {
            if (mMiscTxt == null) {
                mMiscTxt = (TextView) mMiscStub.inflate();
            }
            mMiscTxt.setText(misc);

            RelativeLayout.LayoutParams params = (LayoutParams) mSubTitle.getLayoutParams();
            params.addRule(LEFT_OF, mMiscTxt.getId());
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                params.addRule(START_OF, mMiscTxt.getId());
            }
            mSubTitle.setLayoutParams(params);
        }
    }

    public void setImageIcon(int image) {
        mImageIcon.setImageResource(image);
    }

}
