package com.jaspersoft.sample.dark.theme;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jaspersoft.sample.dark.theme.common.dummy.ResourceFactoryHelper;
import com.jaspersoft.sample.dark.theme.util.StateViewHelper;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.api.ViewServer;


@EActivity
@OptionsMenu(R.menu.repositories)
public class RepositoriesActivity extends Activity {

    @Bean
    protected StateViewHelper mStateHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            mStateHelper.setItems(
                    ResourceFactoryHelper.create()
                            .typeFlag(ResourceType.FOLDER.getFlag())
                            .size(15)
                            .populate()
            );
        }

        mStateHelper.restoreState(savedInstanceState);
        mStateHelper.switchViewStates(getFragmentManager());

        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @OptionsItem(android.R.id.home)
    final void showHome() {
        HomeActivity_.intent(this).flags(Intent.FLAG_ACTIVITY_CLEAR_TOP).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        mStateHelper.setIconState(menu.findItem(R.id.switchLayout));
        return result;
    }

    @OptionsItem
    final void switchLayout(MenuItem item) {
        mStateHelper.toggleIconState(item);
        invalidateOptionsMenu();
        mStateHelper.switchViewStates(getFragmentManager());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mStateHelper.saveState(outState);
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
