package com.jaspersoft.sample.dark.theme.common.dummy;

import com.google.common.base.Objects;

public class DummyItem {
    private final String title;
    private final String subTitle;

    private DummyItem(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public static Builder createBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("title", title)
                .add("subTitle", subTitle)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DummyItem that = (DummyItem) o;

        return Objects.equal(this.title, that.title) &&
                Objects.equal(this.subTitle, that.subTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title, subTitle);
    }


    public static class Builder {
        private String title;
        private String subTitle;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setSubTitle(String subTitle) {
            this.subTitle = subTitle;
            return this;
        }

        public DummyItem build() {
            return new DummyItem(title, subTitle);
        }
    }

}
