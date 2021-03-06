package com.jaspersoft.sample.dark.theme.common.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jaspersoft.sample.dark.theme.ResourceType;
import com.jaspersoft.sample.dark.theme.common.dummy.DummyItem;

import org.androidannotations.annotations.EBean;

@EBean
public class ResourceGridAdapter extends ArrayAdapter<DummyItem> {

    public ResourceGridAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        GridItemView itemView = (GridItemView) convertView;

        if (itemView == null) {
            itemView = GridItemView_.build(getContext());
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
