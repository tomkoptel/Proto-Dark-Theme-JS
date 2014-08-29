package com.jaspersoft.sample.dark.theme.common;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaspersoft.sample.dark.theme.R;
import com.jaspersoft.sample.dark.theme.common.dummy.DummyItem;
import com.jaspersoft.sample.dark.theme.common.widget.ResourceListAdapter;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;

import java.util.ArrayList;

@EFragment
public class ResourceListFragment extends ListFragment {

    @FragmentArg
    protected ArrayList<DummyItem> items;
    @FragmentArg
    protected int actionMenu;

    private ResourceListAdapter mAdapter;

    public ResourceListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_resourcelist_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mAdapter = new ResourceListAdapter(savedInstanceState, actionMenu, items);
        mAdapter.setAdapterView(getListView());

        if (savedInstanceState == null) {
            setListAdapter(mAdapter);
        } else {
            setListAdapter(null);
            setListAdapter(mAdapter);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mAdapter.save(outState);
    }

}
