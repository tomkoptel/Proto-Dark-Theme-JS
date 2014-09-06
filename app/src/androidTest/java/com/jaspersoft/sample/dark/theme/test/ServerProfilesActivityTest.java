package com.jaspersoft.sample.dark.theme.test;

import com.jaspersoft.sample.dark.theme.R;
import com.jaspersoft.sample.dark.theme.ServerProfilesActivity_;
import com.jaspersoft.sample.dark.theme.test.utils.ProtoActivityInstrumentation;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.longClick;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

public class ServerProfilesActivityTest extends ProtoActivityInstrumentation<ServerProfilesActivity_> {
    public ServerProfilesActivityTest() {
        super(ServerProfilesActivity_.class);
    }

    public void testServerProfilesFlow() throws InterruptedException {
        getActivity();
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
        return "server_profiles";
    }
}
