package com.jaspersoft.sample.dark.theme.common.dummy;

import com.jaspersoft.sample.dark.theme.R;
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
    private static final int BASE_COUNT = 50;

    public static int[] BLUE_ICONS = {R.drawable.sample_dashboard_blue, R.drawable.sample_report_blue};
    public static int[] GREY_ICONS = {R.drawable.sample_dashboard_grey, R.drawable.sample_report_grey};
    public static int[] VIOLET_ICONS = {R.drawable.sample_dashboard_violet, R.drawable.sample_report_violet};
    public static int[] ORANGE_ICONS = {R.drawable.sample_dashboard_orange, R.drawable.sample_report_orange};

    public static List<DummyItem> REPORT_ITEMS = new ArrayList<>();
    public static List<DummyItem> DASHBOARD_ITEMS = new ArrayList<>();
    public static List<DummyItem> FOLDER_ITEMS = new ArrayList<>();
    public static List<DummyItem> SAVED_ITEMS = new ArrayList<>();
    public static List<DummyItem> SERVER_ITEMS = new ArrayList<>();

    static {
        generateServers();
        generateSaved();
        generateDashboard();
        generateFolder();
        generateReport();
    }

    private static void generateServers() {
        for (int i = 0; i < BASE_COUNT; i++) {
            addServerItem(DummyItem.createBuilder(ResourceType.SERVER)
                            .setImage(getOrangePreviewIcon())
                            .setTitle(i + ". Server with some sample data")
                            .setSubTitle("http://mobiledemo.jaspersoft.com/jasperserver-pro/" + i)
                            .build()
            );
        }
    }

    private static void generateSaved() {
        for (int i = 0; i < BASE_COUNT; i++) {
            addSavedItem(DummyItem.createBuilder(ResourceType.SAVED)
                            .setImage(getGreyPreviewIcon())
                            .setTitle(i + ". Saved Report")
                            .setSubTitle("Sample report built on supermat data showing performance and sales data form variety of sources")
                            .setFileSzie(randInt(0, BASE_COUNT) + " KB")
                            .build()
            );
        }
    }

    private static void generateDashboard() {
        for (int i = 0; i < BASE_COUNT; i++) {
            addDashboardItem(DummyItem.createBuilder(ResourceType.DASHBOARD)
                            .setImage(getBluePreviewIcon())
                            .setTitle(i + ". Supermart Dashboard")
                            .setSubTitle("Sample dashboard built on supermat data showing performance and sales data form variety of sources")
                            .build()
            );
        }
    }

    private static void generateFolder() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
        for (int i = 0; i < BASE_COUNT; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, (i * -1));
            addFolderItem(DummyItem.createBuilder(ResourceType.FOLDER)
                            .setImage(getVioletPreviewIcon())
                            .setTitle(i + ". Folder with some content")
                            .setSubTitle("/Folder/" + i + "/somewhere/nowhere/anywhere")
                            .setTimestamp(sdf.format(calendar.getTime()))
                            .build()
            );
        }
    }

    private static void generateReport() {
        for (int i = 0; i < BASE_COUNT; i++) {
            addReportItem(DummyItem.createBuilder(ResourceType.REPORT)
                            .setImage(getGreyPreviewIcon())
                            .setTitle(i + ". Geographic Results by Segment Report")
                            .setSubTitle("Sample report built on supermat data showing performance and sales data form variety of sources")
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

    public static int getBluePreviewIcon() {
        return BLUE_ICONS[randInt(0, 1)];
    }

    public static int getGreyPreviewIcon() {
        return GREY_ICONS[randInt(0, 1)];
    }

    public static int getVioletPreviewIcon() {
        return VIOLET_ICONS[randInt(0, 1)];
    }

    public static int getOrangePreviewIcon() {
        return ORANGE_ICONS[randInt(0, 1)];
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

    private static void addServerItem(DummyItem item) {
        SERVER_ITEMS.add(item);
    }

}
