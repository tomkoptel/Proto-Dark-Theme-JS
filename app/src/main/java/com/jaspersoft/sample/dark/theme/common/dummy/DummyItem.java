package com.jaspersoft.sample.dark.theme.common.dummy;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.common.base.Objects;
import com.jaspersoft.sample.dark.theme.ResourceType;

public class DummyItem implements Parcelable {
    private final String title;
    private final String subTitle;
    private final String timestamp;
    private final String fileSize;
    private final ResourceType type;

    private DummyItem(String title, String subTitle, String timestamp, String fileSize, ResourceType type) {
        this.title = title;
        this.subTitle = subTitle;
        this.timestamp = timestamp;
        this.fileSize = fileSize;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getFileSize() {
        return fileSize;
    }

    public ResourceType getType() {
        return type;
    }

    public static Builder createBuilder(ResourceType type) {
        return new Builder(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DummyItem that = (DummyItem) o;

        return Objects.equal(this.title, that.title) &&
                Objects.equal(this.subTitle, that.subTitle) &&
                Objects.equal(this.timestamp, that.timestamp) &&
                Objects.equal(this.fileSize, that.fileSize) &&
                Objects.equal(this.type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, subTitle, timestamp, fileSize, type);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("title", title)
                .add("subTitle", subTitle)
                .add("timestamp", timestamp)
                .add("fileSize", fileSize)
                .add("type", type)
                .toString();
    }

    public static class Builder {
        private String title;
        private String subTitle;
        private String timestamp;
        private String fileSize;
        private ResourceType type;

        public Builder(ResourceType resourceType) {
            type = resourceType;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setSubTitle(String subTitle) {
            this.subTitle = subTitle;
            return this;
        }

        public Builder setTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder setType(ResourceType type) {
            this.type = type;
            return this;
        }

        public Builder setFileSzie(String fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        public DummyItem build() {
            return new DummyItem(title, subTitle, timestamp, fileSize, type);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.subTitle);
        dest.writeString(this.timestamp);
        dest.writeString(this.fileSize);
        dest.writeInt(this.type == null ? -1 : this.type.ordinal());
    }

    private DummyItem(Parcel in) {
        this.title = in.readString();
        this.subTitle = in.readString();
        this.timestamp = in.readString();
        this.fileSize = in.readString();
        int tmpType = in.readInt();
        this.type = tmpType == -1 ? null : ResourceType.values()[tmpType];
    }

    public static final Parcelable.Creator<DummyItem> CREATOR = new Parcelable.Creator<DummyItem>() {
        public DummyItem createFromParcel(Parcel source) {
            return new DummyItem(source);
        }

        public DummyItem[] newArray(int size) {
            return new DummyItem[size];
        }
    };
}
