package com.jaspersoft.sample.dark.theme.common.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.jaspersoft.sample.dark.theme.ResourceType;
import com.jaspersoft.sample.dark.theme.common.dummy.DummyItem;

import java.util.List;

public class ResourceListAdapter extends ResourceMultiChoiceBaseAdapter  {

    public ResourceListAdapter(Bundle savedInstanceState, int actionMenu, List<DummyItem> items) {
        super(savedInstanceState, actionMenu, items);
    }

    @Override
    public View getViewImpl(int position, View convertView, ViewGroup parent) {
        ListItemView itemView = (ListItemView) convertView;

        if (itemView == null) {
            itemView = ListItemView_.build(getContext());
        }

        DummyItem item = getItem(position);
        itemView.setImageIcon(item.image());
        itemView.setTitle(item.title());
        itemView.setSubTitle(item.subTitle());
        if (item.type() == ResourceType.FOLDER) {
            itemView.setTimeTamp(item.timesTamp());
        }
        if (item.type() == ResourceType.SAVED) {
            itemView.setMisc(item.fileSize());
        }
        return itemView;
    }

}
