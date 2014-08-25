package com.jaspersoft.sample.dark.theme.common;

import android.app.ListFragment;
import android.os.Bundle;

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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState == null) {
            mAdapter.setResourceType(resourceType);
            setListAdapter(mAdapter);
            mResourceFactory.populateAdapter(mAdapter, resourceType);
        }
    }

}
