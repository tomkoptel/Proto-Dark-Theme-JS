package com.jaspersoft.sample.dark.theme.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaspersoft.sample.dark.theme.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.DimensionPixelSizeRes;

@EViewGroup(R.layout.resource_list_item)
public class ListItemView extends LinearLayout {

    @ViewById(android.R.id.text1)
    protected TextView mTitleTxt;
    @ViewById(android.R.id.text2)
    protected TextView mSubTitle;

    @DimensionPixelSizeRes(R.dimen.resource_cnt_padding)
    protected int mPadding;

    public ListItemView(Context context) {
        super(context);
    }

    public ListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @AfterViews
    final void init() {
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        setLayoutParams(params);
        setOrientation(LinearLayout.VERTICAL);
        setPadding(mPadding, mPadding, mPadding, mPadding);
    }

    public void setTitle(CharSequence title) {
        mTitleTxt.setText(title);
    }

    public void setSubTitle(CharSequence subTitle) {
        mSubTitle.setText(subTitle);
    }

}
