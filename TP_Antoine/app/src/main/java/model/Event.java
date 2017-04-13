package model;

import java.util.ArrayList;
import java.util.Date;

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
}
