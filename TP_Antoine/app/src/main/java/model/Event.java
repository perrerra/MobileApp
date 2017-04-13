package model;

import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.Date;

import model.base.EntityBase;

/**
 * Created by Pierre on 12/04/2017.
 */

public class Event {
    private String name;
    private Date startDate;
    private Date endDate;
    private ArrayList<User> users;
    private ArrayList<Participation> participants;
    private Place place;
    private EventCat cat;

    public Event(String name, Date startDate, EventCat cat, Place place) {
        this.name = name;
        this.startDate = startDate;
        //this.endDate = endDate;
        this.place = place;
        this.cat = cat;
        this.users = new ArrayList<User>();
        this.participants = new ArrayList<Participation>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Participation> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<Participation> participants) {
        this.participants = participants;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public EventCat getCat() {
        return cat;
    }

    public void setCat(EventCat cat) {
        this.cat = cat;
    }

    public static class EventEntry implements BaseColumns {
        public static final String TABLE_NAME = "event";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_START_DATE = "startDate";
        public static final String COLUMN_NAME_END_DATE = "endDate";
        public static final String COLUMN_NAME_PLACE_ID = "placeID";
        public static final String COLUMN_NAME_EVENT_CAT_ID= "eventCatID";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + Event.EventEntry.TABLE_NAME + " (" +
                        EntityBase.EntityBaseEntry.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                        Event.EventEntry.COLUMN_NAME_NAME + " TEXT," +
                        Event.EventEntry.COLUMN_NAME_START_DATE + " DATE," +
                        Event.EventEntry.COLUMN_NAME_END_DATE + " DATE," +
                        Event.EventEntry.COLUMN_NAME_PLACE_ID + " INTEGER," +
                        Event.EventEntry.COLUMN_NAME_EVENT_CAT_ID + " INTEGER,";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + Event.EventEntry.TABLE_NAME + ";";
    }

}
