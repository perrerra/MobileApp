package model;

/**
 * Created by Pierre on 12/04/2017.
 */

public class Place {

    private String name;
    private Adress adress;
    private int maxPeople;

    public Place(String name, Adress adress, int maxPeople) {
        this.name = name;
        this.adress = adress;
        this.maxPeople = maxPeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }
}
