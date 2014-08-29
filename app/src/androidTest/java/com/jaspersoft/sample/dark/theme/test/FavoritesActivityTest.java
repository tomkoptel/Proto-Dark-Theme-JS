package com.jaspersoft.sample.dark.theme.test;

import com.jaspersoft.sample.dark.theme.FavoritesActivity_;
import com.jaspersoft.sample.dark.theme.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.longClick;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

public class FavoritesActivityTest extends ProtoActivityInstrumentation<FavoritesActivity_> {
    public FavoritesActivityTest() {
        super(FavoritesActivity_.class);
    }

    public void testFlowForFavoritesPage() throws InterruptedException {
        onView(withId(getActionBarId())).perform(click());

        makeScreenShot("list");
        onView(withId(R.id.switchLayout)).perform(click());
        makeScreenShot("grid");

        rotate();
        onView(withId(getActionBarId())).perform(click());
        makeScreenShot("grid");
        onView(withId(R.id.switchLayout)).perform(click());
        makeScreenShot("list");

        rotate();

        makeTwoFirstListItemsAccessible();

        onView(withId(R.id.firs_list_item)).perform(longClick());
        makeScreenShot("one_selected");
        rotate();
        makeScreenShot("one_selected");

        onView(withId(R.id.second_list_item)).perform(longClick());
        makeScreenShot("multi_selected");
        rotate();
        makeScreenShot("multi_selected");
    }

    @Override
    public String getPageName() {
        return "favorites";
    }
}
