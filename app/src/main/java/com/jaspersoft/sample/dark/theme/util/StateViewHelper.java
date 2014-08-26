package com.jaspersoft.sample.dark.theme.util;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;

import com.jaspersoft.sample.dark.theme.R;
import com.jaspersoft.sample.dark.theme.common.ResourceGridFragment_;
import com.jaspersoft.sample.dark.theme.common.ResourceListFragment_;

import org.androidannotations.annotations.EBean;

@EBean
public class StateViewHelper {
    private static final String KEY_VIEW_STATE = "VIEW_STATE";

    private static final int NO_STATE = -1;
    private static final int SHOW_GRID = 1;
    private static final int SHOW_LIST = 2;

    protected int mViewState = SHOW_GRID;

    protected int resourceFlag;
    protected int size;
    protected boolean shuffle;

    public void toggleIconState(MenuItem item) {
        if (mViewState == SHOW_GRID) {
            mViewState = SHOW_LIST;
            item.setIcon(R.drawable.ic_collections_view_as_grid);
        } else {
            mViewState = SHOW_GRID;
            item.setIcon(R.drawable.ic_collections_view_as_list);
        }
    }

    public void switchViewStates(FragmentManager manager) {
        Fragment fragment;
        if (mViewState == SHOW_GRID) {
            fragment = ResourceListFragment_.builder()
                    .resourceFlag(resourceFlag)
                    .size(size)
                    .shuffle(shuffle)
                    .build();
        } else {
            fragment = ResourceGridFragment_.builder()
                    .resourceFlag(resourceFlag)
                    .size(size)
                    .shuffle(shuffle)
                    .build();
        }
        manager.beginTransaction()
                .setCustomAnimations(
                R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                R.animator.card_flip_left_in, R.animator.card_flip_left_out)
                .replace(android.R.id.content, fragment)
                .commit();
    }

    public void saveState(Bundle outState) {
        outState.putInt(KEY_VIEW_STATE, mViewState);
    }

    public void restoreState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mViewState = savedInstanceState.getInt(KEY_VIEW_STATE, SHOW_GRID);
        }
    }

    public void setIconState(MenuItem item) {
        if (mViewState == SHOW_GRID) {
            item.setIcon(R.drawable.ic_collections_view_as_grid);
        } else {
            item.setIcon(R.drawable.ic_collections_view_as_list);
        }
    }

    public void setResourceFlag(int resourceFlag) {
        this.resourceFlag = resourceFlag;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setShuffle(boolean shuffle) {
        this.shuffle = shuffle;
    }
}
