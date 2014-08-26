package com.jaspersoft.sample.dark.theme.common;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;

import com.jaspersoft.sample.dark.theme.R;
import com.jaspersoft.sample.dark.theme.common.dummy.DummyItem;
import com.jaspersoft.sample.dark.theme.common.widget.ResourceGridAdapter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EFragment(R.layout.fragment_resourcelist_grid)
public class ResourceGridFragment extends Fragment {

    @FragmentArg
    protected ArrayList<DummyItem> items;

    @ViewById(android.R.id.list)
    protected AbsListView mGridView;

    @Bean
    protected ResourceGridAdapter mAdapter;

    public ResourceGridFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState == null) {
            mGridView.setAdapter(mAdapter);
            mAdapter.addAll(items);
        }
    }

    /**
     * The default title for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mGridView.getEmptyView();

        if (emptyText instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }
}
