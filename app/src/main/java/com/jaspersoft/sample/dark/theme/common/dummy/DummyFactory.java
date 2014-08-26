package com.jaspersoft.sample.dark.theme.common.dummy;

import com.jaspersoft.sample.dark.theme.ResourceType;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Helper class for providing sample title for user interfaces created by
 */
public class DummyFactory {

    public static List<DummyItem> REPORT_ITEMS = new ArrayList<>();
    public static List<DummyItem> DASHBOARD_ITEMS = new ArrayList<>();
    public static List<DummyItem> FOLDER_ITEMS = new ArrayList<>();
    public static List<DummyItem> SAVED_ITEMS = new ArrayList<>();

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
                            .setSubTitle("Dashboards/" + i + ".Supermart_Dashboard")
                            .build()
            );
        }
        for (int i = 0; i < 100; i++) {
            addSavedItem(DummyItem.createBuilder(ResourceType.SAVED)
                            .setTitle(i + ". Saved Report")
                            .setSubTitle("Reports/" + i + "._Geographic_Results_by_Segment_Report")
                            .setFileSzie(randInt(0, 100) + " KB")
                            .build()
            );
        }
    }

    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
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

    private static void addSavedItem(DummyItem item) {
        SAVED_ITEMS.add(item);
    }

}
