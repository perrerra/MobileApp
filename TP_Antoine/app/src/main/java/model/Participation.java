package model;

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
}
