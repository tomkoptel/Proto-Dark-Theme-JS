package com.jaspersoft.sample.dark.theme.test;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.squareup.spoon.Spoon;

public abstract class ProtoActivityInstrumentation<T extends Activity>
        extends ActivityInstrumentationTestCase2<T> {
    private T mActivity;
    private NameUtils nameUtils;

    public ProtoActivityInstrumentation(Class<T> activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        nameUtils = new NameUtils(getPageName());
        mActivity = getActivity();
    }

    protected void makeScreenShot(String name) throws InterruptedException {
        Thread.sleep(400);
        Spoon.screenshot(mActivity, nameUtils.generateName(mActivity, name));
    }

    protected void rotate() {
        switch(mActivity.getResources().getConfiguration().orientation) {
            case Configuration.ORIENTATION_PORTRAIT:
                rotateToLandscape();
                break;
            case Configuration.ORIENTATION_LANDSCAPE:
                rotateToPortrait();
                break;
        }
    }

    protected void rotateToLandscape() {
        mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    protected void rotateToPortrait() {
        mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    protected int getSearcFieldId() {
        return mActivity.getResources().getIdentifier("search_src_text", "id", "android");
    }

    protected int getActionBarId() {
        return mActivity.getResources().getIdentifier("action_bar", "id", "android");
    }

    protected View findViewById(int id) {
        return mActivity.findViewById(id);
    }

    public abstract String getPageName();
}