package model.entitiesLink;

import android.provider.BaseColumns;

import model.Address;
import model.base.EntityBase;

/**
 * Created by Pierre on 13/04/2017.
 */

public class EventUser {

    public static class EventUserEntry implements BaseColumns {
        public static final String TABLE_NAME = "event_user";
        public static final String COLUMN_NAME_EVENT_ID = "event_id";
        public static final String COLUMN_NAME_USER_ID = "user_id";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + EventUser.EventUserEntry.TABLE_NAME + " (" +
                        EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                        EventUser.EventUserEntry.COLUMN_NAME_EVENT_ID + " INTEGER," +
                        EventUser.EventUserEntry.COLUMN_NAME_USER_ID + " INTEGER,";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + Address.AddressEntry.TABLE_NAME + ";";
    }

}
