package com.jaspersoft.sample.dark.theme.common.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jaspersoft.sample.dark.theme.ResourceType;
import com.jaspersoft.sample.dark.theme.common.dummy.DummyItem;

import org.androidannotations.annotations.EBean;

@EBean
public class ResourceListAdapter extends ArrayAdapter<DummyItem> {

    public ResourceListAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemView itemView = (ListItemView) convertView;

        if (itemView == null) {
            itemView = ListItemView_.build(getContext());
        }

        DummyItem item = getItem(position);
        itemView.setImageIcon(item.getImage());
        itemView.setTitle(item.getTitle());
        itemView.setSubTitle(item.getSubTitle());
        if (item.getType() == ResourceType.FOLDER) {
            itemView.setTimeTamp(item.getTimestamp());
        }
        if (item.getType() == ResourceType.SAVED) {
            itemView.setMisc(item.getFileSize());
        }
        return itemView;
    }

}
