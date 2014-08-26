package com.jaspersoft.sample.dark.theme.common.dummy;

import android.widget.ArrayAdapter;

import com.jaspersoft.sample.dark.theme.ResourceType;

import org.androidannotations.annotations.EBean;

@EBean(scope = EBean.Scope.Singleton)
public class ResourceFactoryHelper {

    public void populateAdapter(ArrayAdapter<DummyItem> adapter,
                                ResourceType type) {
        switch (type) {
            case REPORT:
                adapter.addAll(DummyFactory.REPORT_ITEMS);
                break;
            case FOLDER:
                adapter.addAll(DummyFactory.FOLDER_ITEMS);
                break;
        }
    }

}
