package com.jaspersoft.sample.dark.theme;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.jaspersoft.sample.dark.theme.util.StateViewHelper;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;

@EActivity
@OptionsMenu(R.menu.libraries)
public class LibrariesActivity extends Activity {

    @Bean
    protected StateViewHelper mStateHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStateHelper.restoreState(savedInstanceState);
        mStateHelper.switchViewStates(
                getFragmentManager(), ResourceType.REPORT);
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
        mStateHelper.switchViewStates(
                getFragmentManager(), ResourceType.REPORT);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mStateHelper.saveState(outState);
    }

}
