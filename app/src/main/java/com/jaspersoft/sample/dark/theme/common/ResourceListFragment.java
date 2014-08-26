package com.jaspersoft.sample.dark.theme.common;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaspersoft.sample.dark.theme.R;
import com.jaspersoft.sample.dark.theme.ResourceType;
import com.jaspersoft.sample.dark.theme.common.dummy.ResourceFactoryHelper;
import com.jaspersoft.sample.dark.theme.common.widget.ResourceListAdapter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;

@EFragment
public class ResourceListFragment extends ListFragment {

    @FragmentArg
    protected ResourceType resourceType;

    @Bean
    protected ResourceListAdapter mAdapter;
    @Bean
    protected ResourceFactoryHelper mResourceFactory;

    public ResourceListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_resourcelist_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState == null) {
            mAdapter.setResourceType(resourceType);
            setListAdapter(mAdapter);
            mResourceFactory.populateAdapter(mAdapter, resourceType);
        }
    }

}
