package model;

/**
 * Created by Pierre on 12/04/2017.
 */

public class Place {

    private String name;
    private Address address;
    private int maxPeople;

    public Place(String name, Address address, int maxPeople) {
        this.name = name;
        this.address = address;
        this.maxPeople = maxPeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }
}
