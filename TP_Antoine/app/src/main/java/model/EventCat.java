package model;

import android.provider.BaseColumns;

import model.base.EntityBase;

/**
 * Created by Pierre on 12/04/2017.
 */

public class EventCat {
    private String name;

    public EventCat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class EventCatEntry implements BaseColumns {
        public static final String TABLE_NAME = "eventCat";
        public static final String COLUMN_NAME_NAME = "name";


        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " +  EventCat.EventCatEntry.TABLE_NAME + " (" +
                        EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                        EventCat.EventCatEntry.COLUMN_NAME_NAME + " TEXT);";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " +  EventCat.EventCatEntry.TABLE_NAME + ";";
    }



}
