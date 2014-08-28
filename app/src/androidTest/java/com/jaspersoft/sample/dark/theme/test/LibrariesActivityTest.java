package com.jaspersoft.sample.dark.theme.test;


import android.view.View;

import com.google.android.apps.common.testing.ui.espresso.Espresso;
import com.jaspersoft.sample.dark.theme.LibrariesActivity_;
import com.jaspersoft.sample.dark.theme.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;

public class LibrariesActivityTest extends ProtoActivityInstrumentation<LibrariesActivity_> {
    public LibrariesActivityTest() {
        super(LibrariesActivity_.class);
    }

    public void testFlowForLibrariesPage() throws InterruptedException {
        onView(withId(getActionBarId())).perform(click());
        View filterView = findViewById(R.id.switchLayout);

        // This means that we are in handset mode
        if (filterView == null) {
            openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
            makeScreenShot("list");
            Espresso.pressBack();
        } else {
            makeScreenShot("list");
        }

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
    }

    @Override
    public String getPageName() {
        return "libraries";
    }
}
