package com.jaspersoft.sample.dark.theme;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.jaspersoft.sample.dark.theme.widget.MyWebView;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.WindowFeature;

/**
 * @author Tom Koptel
 * @since 2.0
 */
@EActivity
@WindowFeature({Window.FEATURE_PROGRESS})
public class WebViewActivity extends Activity {
    private MyWebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setProgressBarIndeterminateVisibility(true);

        if (mWebView == null) {
            mWebView = new MyWebView(this);
            mWebView.setId(R.id.web_view);
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.setWebChromeClient(new ChromeClient());
            mWebView.getSettings().setBuiltInZoomControls(true);
            mWebView.getSettings().setLoadWithOverviewMode(true);
            mWebView.getSettings().setUseWideViewPort(true);
        }
        setContentView(mWebView);
        setProgress(0);
        mWebView.loadUrl("https://www.google.com.ua/");
    }

    public MyWebView getWebView() {
        return mWebView;
    }

    private class ChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            int progress = (Window.PROGRESS_END - Window.PROGRESS_START) / 100 * newProgress;
            setProgress(progress);

            if (newProgress == 100) {
                setProgressBarIndeterminateVisibility(false);
            }
        }
    }
}
