package com.jaspersoft.sample.dark.theme;

import android.app.Activity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.api.ViewServer;

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
        SavedItemsActivity_.intent(this).start();
    }

    @Click
    final void showServers() {
        ServerProfilesActivity_.intent(this).start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        ViewServer.get(this).addWindow(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewServer.get(this).removeWindow(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewServer.get(this).setFocusedWindow(this);
    }
}
