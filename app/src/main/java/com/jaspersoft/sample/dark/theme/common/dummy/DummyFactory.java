package com.jaspersoft.sample.dark.theme.common.dummy;

import com.jaspersoft.sample.dark.theme.ResourceType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Helper class for providing sample title for user interfaces created by
 */
public class DummyFactory {

    public static List<DummyItem> REPORT_ITEMS = new ArrayList<>();
    public static List<DummyItem> DASHBOARD_ITEMS = new ArrayList<>();
    public static List<DummyItem> FOLDER_ITEMS = new ArrayList<>();

    static {
        for (int i = 0; i < 100; i++) {
            addReportItem(DummyItem.createBuilder(ResourceType.REPORT)
                            .setTitle(i + ". Geographic Results by Segment Report")
                            .setSubTitle("Reports/" + i  +"._Geographic_Results_by_Segment_Report")
                            .build()
            );
        }
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
        for (int i = 0; i < 100; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, (i * -1));
            addFolderItem(DummyItem.createBuilder(ResourceType.FOLDER)
                            .setTitle(i + ". Folder")
                            .setSubTitle("/Folder" + i)
                            .setTimestamp(sdf.format(calendar.getTime()))
                            .build()
            );
        }
        for (int i = 0; i < 100; i++) {
            addDashboardItem(DummyItem.createBuilder(ResourceType.DASHBOARD)
                            .setTitle(i + ". Supermart Dashboard")
                            .setSubTitle("Dashboards/" + i  +".Supermart_Dashboard")
                            .build()
            );
        }
    }

    private static void addReportItem(DummyItem item) {
        REPORT_ITEMS.add(item);
    }

    private static void addFolderItem(DummyItem item) {
        FOLDER_ITEMS.add(item);
    }

    private static void addDashboardItem(DummyItem item) {
        DASHBOARD_ITEMS.add(item);
    }

}
