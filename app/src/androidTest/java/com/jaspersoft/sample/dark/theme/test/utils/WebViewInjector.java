package com.jaspersoft.sample.dark.theme.test.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.util.Log;

import com.google.android.apps.common.testing.testrunner.ActivityLifecycleCallback;
import com.google.android.apps.common.testing.testrunner.Stage;
import com.jaspersoft.sample.dark.theme.WebViewActivity;
import com.jaspersoft.sample.dark.theme.WebViewActivity_;

/**
 * @author Tom Koptel
 * @since 2.0
 */
public class WebViewInjector implements ActivityLifecycleCallback {
    private final WebViewIdlingResource webViewIdlingResource;

    public WebViewInjector(WebViewIdlingResource webViewIdlingResource) {
        this.webViewIdlingResource = webViewIdlingResource;
    }

    @Override
    public void onActivityLifecycleChanged(Activity activity, Stage stage) {
        Log.d("hoho", "Activity " + activity + " Stage " + stage);

        ComponentName websiteActivityComponentName =
                new ComponentName(activity, WebViewActivity_.class.getName());
        if (!activity.getComponentName().equals(websiteActivityComponentName)) return;
        Log.d("hoho", "!!!!!!!!!!!!!!!!!!!!!!!!!");

        switch (stage) {
            case CREATED:
                // We need to wait for the activity to be created before getting a reference
                // to the webview
                WebViewActivity webViewActivity = (WebViewActivity) activity;
                webViewIdlingResource.inject(webViewActivity.getWebView());
                break;
            case STOPPED:
                // Clean up reference
                if (activity.isFinishing()) webViewIdlingResource.clear();
                break;
            default: // NOP
        }
    }
}
