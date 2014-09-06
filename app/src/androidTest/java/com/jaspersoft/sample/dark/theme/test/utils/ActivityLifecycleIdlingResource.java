package com.jaspersoft.sample.dark.theme.test.utils;

import com.google.android.apps.common.testing.ui.espresso.IdlingResource;

/**
 * @author Tom Koptel
 * @since 2.0
 */
public interface ActivityLifecycleIdlingResource<T> extends IdlingResource {

    void inject(T activityComponent);

    void clear();
}