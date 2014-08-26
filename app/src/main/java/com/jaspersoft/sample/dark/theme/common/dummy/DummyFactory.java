package com.jaspersoft.sample.dark.theme.common.dummy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample title for user interfaces created by
 */
public class DummyFactory {

    public static List<DummyItem> REPORT_ITEMS = new ArrayList<>();
    public static Map<Integer, DummyItem> REPORT_ITEM_MAP = new HashMap<>();

    public static List<DummyItem> FOLDER_ITEMS = new ArrayList<>();
    public static Map<Integer, DummyItem> FOLDER_ITEMS_MAP = new HashMap<>();

    static {
        for (int i = 0; i < 100; i++) {
            addReportItem(DummyItem.createBuilder()
                            .setTitle(i + ". Geographic Results by Segment Report")
                            .setSubTitle("Reports/" + i  +"._Geographic_Results_by_Segment_Report")
                            .build()
            );
        }
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
        for (int i = 0; i < 100; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, (i * -1));
            addFolderItem(DummyItem.createBuilder()
                            .setTitle(i + ". Folder")
                            .setSubTitle("/Folder" + i)
                            .setTimestamp(sdf.format(calendar.getTime()))
                            .build()
            );
        }
    }

    private static void addReportItem(DummyItem item) {
        REPORT_ITEMS.add(item);
        REPORT_ITEM_MAP.put(item.hashCode(), item);
    }

    private static void addFolderItem(DummyItem item) {
        FOLDER_ITEMS.add(item);
        FOLDER_ITEMS_MAP.put(item.hashCode(), item);
    }

}
