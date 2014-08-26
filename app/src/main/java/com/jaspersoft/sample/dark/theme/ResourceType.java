package com.jaspersoft.sample.dark.theme;

public enum ResourceType {
    REPORT(0x1), FOLDER(0x2), DASHBOARD(0x4), PROFILE(0x8);

    private final int mFlag;

    ResourceType(int flag) {
        mFlag = flag;
    }

    public int getFlag() {
        return mFlag;
    }
}