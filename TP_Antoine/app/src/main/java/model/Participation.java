package model;

import android.provider.BaseColumns;

import model.base.EntityBase;

/**
 * Created by Pierre on 12/04/2017.
 */

public class Participation {

    private User user;
    private Event event;
    private boolean hasCome;

    public Participation(User user, Event event, boolean hasCome) {
        this.user = user;
        this.event = event;
        this.hasCome = hasCome;
    }

    public User getUser() {

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public boolean isHasCome() {
        return hasCome;
    }

    public void setHasCome(boolean hasCome) {
        this.hasCome = hasCome;
    }

    public static class ParticipationEntry implements BaseColumns {
        public static final String TABLE_NAME = "participation";
        public static final String COLUMN_NAME_USER_ID = "user_id";
        public static final String COLUMN_NAME_EVENT_ID = "event_id";
        public static final String COLUMN_NAME_HAS_COME = "has_come";


        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " +  Participation.ParticipationEntry.TABLE_NAME + " (" +
                        EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                        Participation.ParticipationEntry.COLUMN_NAME_USER_ID + " INTEGER);" +
                        Participation.ParticipationEntry.COLUMN_NAME_EVENT_ID + " INTEGER);" +
                        Participation.ParticipationEntry.COLUMN_NAME_HAS_COME + " BIT);" ;

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " +  Participation.ParticipationEntry.TABLE_NAME + ";";
    }

}
