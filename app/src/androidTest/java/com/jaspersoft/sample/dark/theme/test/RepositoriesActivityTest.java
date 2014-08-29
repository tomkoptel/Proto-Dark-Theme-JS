package com.jaspersoft.sample.dark.theme.test;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.jaspersoft.sample.dark.theme.R;
import com.jaspersoft.sample.dark.theme.RepositoriesActivity_;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.longClick;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

public class RepositoriesActivityTest extends ProtoActivityInstrumentation<RepositoriesActivity_> {
    public RepositoriesActivityTest() {
        super(RepositoriesActivity_.class);
    }


    public void testFlowForRepositories() throws InterruptedException {
        onView(withId(getActionBarId())).perform(click());

        makeScreenShot("list");
        onView(withId(R.id.switchLayout)).perform(click());
        makeScreenShot("grid");

        onView(withId(R.id.search)).perform(click());
        onView(withId(getSearcFieldId())).perform(typeText("Search query"));
        makeScreenShot("search");
        Espresso.pressBack();
        Espresso.pressBack();

        rotate();
        onView(withId(getActionBarId())).perform(click());
        makeScreenShot("grid");
        onView(withId(R.id.switchLayout)).perform(click());
        makeScreenShot("list");

        onView(withId(R.id.search)).perform(click());
        onView(withId(getSearcFieldId())).perform(typeText("Search query"));
        makeScreenShot("search");

        Espresso.pressBack();
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
        return "repositories";
    }

}
