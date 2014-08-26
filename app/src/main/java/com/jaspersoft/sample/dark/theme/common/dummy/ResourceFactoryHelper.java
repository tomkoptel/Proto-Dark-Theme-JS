package com.jaspersoft.sample.dark.theme.common.dummy;

import com.jaspersoft.sample.dark.theme.ResourceType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ResourceFactoryHelper {
    private int typeFlag;
    private int size;
    private boolean shuffle;

    public ResourceFactoryHelper(int typeFlag, int count, boolean shuffle) {
        this.typeFlag = typeFlag;
        this.size = count;
        this.shuffle = shuffle;
    }

    public List<DummyItem> generateItems() {
        List<DummyItem> items = new ArrayList<>();

        if ((typeFlag & ResourceType.FOLDER.getFlag()) == ResourceType.FOLDER.getFlag()) {
            items.addAll(DummyFactory.FOLDER_ITEMS);
        }

        if ((typeFlag & ResourceType.REPORT.getFlag()) == ResourceType.REPORT.getFlag()) {
            items.addAll(DummyFactory.REPORT_ITEMS);
        }

        if ((typeFlag & ResourceType.DASHBOARD.getFlag()) == ResourceType.DASHBOARD.getFlag()) {
            items.addAll(DummyFactory.DASHBOARD_ITEMS);
        }

        if (shuffle) {
            long seed = System.nanoTime();
            Collections.shuffle(items, new Random(seed));
        }

        if (size > 0) {
            return items.subList(0, size - 1);
        }

        return items;
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder {
        private int typeFlag;
        private int size;
        private boolean shuffle;

        public Builder setTypeFlag(int typeFlag) {
            this.typeFlag = typeFlag;
            return this;
        }

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setShuffle(boolean shuffle) {
            this.shuffle = shuffle;
            return this;
        }


        public List<DummyItem> populate() {
            return new ResourceFactoryHelper(typeFlag, size, shuffle).generateItems();
        }
    }

}
