package com.jaspersoft.sample.dark.theme.test;

import android.util.Log;

import com.google.android.apps.common.testing.testrunner.ActivityLifecycleMonitorRegistry;
import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.jaspersoft.sample.dark.theme.R;
import com.jaspersoft.sample.dark.theme.WebViewActivity_;
import com.jaspersoft.sample.dark.theme.test.utils.ProtoActivityInstrumentation;
import com.jaspersoft.sample.dark.theme.test.utils.WebViewIdlingResource;
import com.jaspersoft.sample.dark.theme.test.utils.WebViewInjector;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.doubleClick;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.isDisplayed;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

/**
 * @author Tom Koptel
 * @since 2.0
 */
public class WebViewActivityTest extends ProtoActivityInstrumentation<WebViewActivity_> {
    private WebViewInjector injector;

    public WebViewActivityTest() {
        super(WebViewActivity_.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        WebViewIdlingResource webViewIdlingResource = new WebViewIdlingResource();
        Espresso.registerIdlingResources(webViewIdlingResource);
        injector = new WebViewInjector(webViewIdlingResource);
        ActivityLifecycleMonitorRegistry.getInstance()
                .addLifecycleCallback(injector);
        getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        ActivityLifecycleMonitorRegistry.getInstance()
                .removeLifecycleCallback(injector);
        super.tearDown();
    }

    @Override
    public String getPageName() {
        return "webview";
    }

    public void testInitialLoad() {
        onView(withText("Web view")).check(matches(isDisplayed()));
        for (int i = 0; i < 10; i++) {
            onView(withId(R.id.web_view)).perform(doubleClick());
            Log.d("hoho", "It is " + (i + 1) + "click");
        }
    }
}
