package com.jaspersoft.sample.dark.theme.test.utils;

import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.jaspersoft.sample.dark.theme.widget.MyWebView;

import static com.google.android.apps.common.testing.testrunner.util.Checks.checkNotNull;

/**
 * @author Tom Koptel
 * @since 2.0
 */
public class WebViewIdlingResource extends WebChromeClient
        implements ActivityLifecycleIdlingResource<MyWebView> {

    private static final int FINISHED = 100;

    private MyWebView webView;
    private ResourceCallback callback;
    private WebChromeClient mWebChromeClient;

    @Override
    public void inject(MyWebView appComponent) {
        this.webView = checkNotNull(appComponent,
                String.format("Trying to instantiate a \'%s\' with a null WebView", getName()));
        // Save the original client if needed.
        mWebChromeClient = webView.getWebChromeClient();

        this.webView.setWebChromeClient(this);
    }

    @Override
    public void clear() {
        // Free up the reference to the webView
        webView = null;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        Log.d("hoho", "onProgressChanged " + newProgress);
        if (newProgress == FINISHED && callback != null) {
            callback.onTransitionToIdle();
        }
        if (mWebChromeClient != null) {
            mWebChromeClient.onProgressChanged(view, newProgress);
        }
    }

    @Override
    public String getName() {
        return "WebView idling resource";
    }

    @Override
    public boolean isIdleNow() {
        boolean isIdleNow = false;

        // The webView hasn't been injected yet, so we're idling
        if (webView == null) {
            isIdleNow = true;
            Log.d("hoho", "(webView == null) isIdleNow " + isIdleNow);
            return isIdleNow;
        }
        isIdleNow = webView.getProgress() == FINISHED && callback != null;
        Log.d("hoho", "(webView.getProgress() == FINISHED && callback != null) isIdleNow " + isIdleNow);
        return isIdleNow;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
        Log.d("hoho", "registerIdleTransitionCallback");
        this.callback = resourceCallback;
    }

}
