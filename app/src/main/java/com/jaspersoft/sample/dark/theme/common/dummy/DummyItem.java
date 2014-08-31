package com.jaspersoft.sample.dark.theme.common.dummy;

import android.os.Parcelable;

import com.jaspersoft.sample.dark.theme.ResourceType;

import javax.annotation.Nullable;

import auto.parcel.AutoParcel;

@AutoParcel
public abstract class DummyItem implements Parcelable {

    public abstract String title();

    public abstract String subTitle();

    public abstract ResourceType type();

    @Nullable
    public abstract String timesTamp();

    @Nullable
    public abstract String fileSize();

    @Nullable
    public abstract int image();

    public static DummyItem createServer(String title, String subTitle, int image) {
        return new AutoParcel_DummyItem(title, subTitle, ResourceType.SERVER, null, null, image);
    }

    public static DummyItem createSavedItem(String title, String subTitle, String fileSize, int image) {
        return new AutoParcel_DummyItem(title, subTitle, ResourceType.SAVED, null, fileSize, image);
    }

    public static DummyItem createDashboard(String title, String subTitle, int image) {
        return new AutoParcel_DummyItem(title, subTitle, ResourceType.DASHBOARD, null, null, image);
    }

    public static DummyItem createFolder(String title, String subTitle, int image, String timestamp) {
        return new AutoParcel_DummyItem(title, subTitle, ResourceType.FOLDER, timestamp, null, image);
    }

    public static DummyItem createReport(String title, String subTitle, int image) {
        return new AutoParcel_DummyItem(title, subTitle, ResourceType.REPORT, null, null, image);
    }

}
