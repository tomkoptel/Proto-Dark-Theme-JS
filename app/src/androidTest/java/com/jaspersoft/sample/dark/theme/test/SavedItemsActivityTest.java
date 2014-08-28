package com.jaspersoft.sample.dark.theme.test;

import com.jaspersoft.sample.dark.theme.R;
import com.jaspersoft.sample.dark.theme.SavedItemsActivity_;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

/**
 * @author Tom Koptel
 * @since 2.0
 */
public class SavedItemsActivityTest  extends ProtoActivityInstrumentation<SavedItemsActivity_> {
    public SavedItemsActivityTest() {
        super(SavedItemsActivity_.class);
    }

    public void testFlowForSavedItems() throws InterruptedException {
        onView(withId(getActionBarId())).perform(click());

        makeScreenShot("list");
        onView(withId(R.id.switchLayout)).perform(click());
        makeScreenShot("grid");

        rotate();
        onView(withId(getActionBarId())).perform(click());

        makeScreenShot("grid");
        onView(withId(R.id.switchLayout)).perform(click());
        makeScreenShot("list");
    }

    @Override
    public String getPageName() {
        return "saved_items";
    }
}
