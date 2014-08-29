package com.jaspersoft.sample.dark.theme.common.widget;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.jaspersoft.sample.dark.theme.R;
import com.jaspersoft.sample.dark.theme.common.dummy.DummyItem;
import com.jaspersoft.sample.dark.theme.multichoice.AwareMultiChoiceAdapterHelper;
import com.jaspersoft.sample.dark.theme.multichoice.AwareMultiChoiceBaseAdapter;

import java.util.List;

public abstract class ResourceMultiChoiceBaseAdapter extends AwareMultiChoiceBaseAdapter
        implements AwareMultiChoiceAdapterHelper.OnItemCheckedListener {

    private final List<DummyItem> items;
    private final int actionMenu;
    private MenuItem runItem;
    private MenuItem viewDetails;
    private MenuItem renameItem;
    private MenuItem connectItem;

    public ResourceMultiChoiceBaseAdapter(Bundle savedInstanceState, int actionMenu, List<DummyItem> items) {
        super(savedInstanceState);
        this.items = items;
        this.actionMenu = actionMenu;
        setOnCheckeditemListener(this);
    }

    @Override
    public String getActionModeTitle(int count) {
        return getContext().getResources().getString(R.string.selected, count);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        if (actionMenu == 0) return false;
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(actionMenu, menu);
        runItem = menu.findItem(R.id.menu_run);
        viewDetails = menu.findItem(R.id.menu_view_details);
        renameItem = menu.findItem(R.id.menu_edit_item);
        connectItem = menu.findItem(R.id.menu_connect_item);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        boolean shouldHideSingleItemAction = getCheckedItemCount() <= 1;
        boolean processed = false;

        if (runItem != null) {
            runItem.setVisible(shouldHideSingleItemAction);
            processed = true;
        }
        if (viewDetails != null) {
            viewDetails.setVisible(shouldHideSingleItemAction);
            processed = true;
        }
        if (renameItem != null) {
            renameItem.setVisible(shouldHideSingleItemAction);
            processed = true;
        }
        if (connectItem != null) {
            connectItem.setVisible(shouldHideSingleItemAction);
            processed = true;
        }

        return processed;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public DummyItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onItemChecked(long handle, boolean checked) {
        if (!(getCheckedItemCount() > 2)) {
            invalidateActionMode();
        }
    }
}
