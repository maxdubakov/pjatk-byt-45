package implementation1;

import implementation1.util.Place;

import java.time.LocalDate;

public class Car extends Technic {

    private final boolean fourWheelDrive;
    private static final int LITER_PER_KM = 1;

    public Car(int maxWeight, int maxPeople, int maxFuel, LocalDate productionDate, int currentWeight, int currentPeople, int currentFuel, boolean fourWheelDrive) {
        super(maxWeight, maxPeople, maxFuel, productionDate, currentWeight, currentPeople, currentFuel);
        this.fourWheelDrive = fourWheelDrive;
        this.construct();
    }

    @Override
    public void construct() {
        System.out.println("Car has been constructed");
    }

    @Override
    public boolean travel(Place a, Place b) {
        if ((!super.travel(a, b)) || (!this.test()) || (!examineBeforeTravel(a, b))) {
            return false;
        }

        this.currentFuel(this.currentFuel() - (int)Place.calculateDistance(a, b) * LITER_PER_KM);
        System.out.println("Car has driven from place " + a + " to place " + b);
        System.out.println("Current state of chosen car: " + this);
        return true;
    }

    @Override
    public boolean test() {
        boolean good = Math.random() > 0.2;
        if (!good) {
            System.out.println("The car you have chosen is broken");
        }
        return good;
    }

    @Override
    public boolean examineBeforeTravel(Place a, Place b) {
        if (currentFuel() * LITER_PER_KM < Place.calculateDistance(a, b)) {
            System.out.println("There is not enough fuel in this car. Pick another one...");
            return false;
        }
        return true;
    }

    public boolean fourWheelDrive() {
        return fourWheelDrive;
    }
}
