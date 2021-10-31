package implementation1;

import implementation1.util.Place;

import java.time.LocalDate;

public abstract class Technic {
    private final int maxWeight;
    private final int maxPeople;
    private final int maxFuel;
    private final LocalDate productionDate;
    private int currentWeight;
    private int currentPeople;
    private int currentFuel;

    public Technic(int maxWeight, int maxPeople, int maxFuel, LocalDate productionDate, int currentWeight, int currentPeople, int currentFuel) {
        this.maxWeight = maxWeight;
        this.maxPeople = maxPeople;
        this.maxFuel = maxFuel;
        this.productionDate = productionDate;
        this.currentWeight = currentWeight;
        this.currentPeople = currentPeople;
        this.currentFuel = currentFuel;
    }

    public abstract void construct();

    public boolean travel(Place a, Place b) {
        return currentFuel > 0 && currentPeople > 0;
    }

    public void getFuel(int litres) {
        if (currentFuel + litres > maxFuel) {
            System.out.println("Too much fuel");
            return;
        }
        currentFuel += litres;
    }

    public abstract boolean test();

    public abstract boolean examineBeforeTravel(Place a, Place b);

    public boolean overweight() {
        return currentWeight > maxWeight;
    }

    public boolean overcrowded() {
        return currentPeople > maxPeople;
    }

    public void currentPeople(int people) {
        this.currentPeople = people;
    }

    public void currentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public void currentFuel(int currentFuel) {
        this.currentFuel = currentFuel;
    }

    public int maxWeight() {
        return maxWeight;
    }

    public int maxPeople() {
        return maxPeople;
    }

    public int maxFuel() {
        return maxFuel;
    }

    public LocalDate productionDate() {
        return productionDate;
    }

    public int currentWeight() {
        return currentWeight;
    }

    public int currentPeople() {
        return currentPeople;
    }

    public int currentFuel() {
        return currentFuel;
    }

    @Override
    public String toString() {
        return "Technic{" +
                "maxWeight=" + maxWeight +
                ", maxPeople=" + maxPeople +
                ", maxFuel=" + maxFuel +
                ", productionDate=" + productionDate +
                ", currentWeight=" + currentWeight +
                ", currentPeople=" + currentPeople +
                ", currentFuel=" + currentFuel +
                '}';
    }
}
