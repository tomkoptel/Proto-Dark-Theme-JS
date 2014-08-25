package com.jaspersoft.sample.dark.theme;

import android.app.Activity;
import android.os.Bundle;

import com.jaspersoft.sample.dark.theme.common.ResourceListFragment;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsMenu;

@EActivity()
@OptionsMenu(R.menu.favorites)
public class FavoritesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            ResourceListFragment fragment = new ResourceListFragment();
            getFragmentManager().beginTransaction().
                    add(android.R.id.content, fragment)
                    .commit();
        }
    }

}
