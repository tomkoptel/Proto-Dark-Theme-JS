package com.jaspersoft.sample.dark.theme;

import android.app.Activity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_home)
public class HomeActivity extends Activity {

    @Click
    final void showRepositories() {
        RepositoriesActivity_.intent(this).start();
    }

    @Click
    final void showLibraries() {
        LibrariesActivity_.intent(this).start();
    }

    @Click
    final void showFavorites() {
        FavoritesActivity_.intent(this).start();
    }

    @Click
    final void showSavedItems() {

    }

}
