package implementation1;

import implementation1.util.Place;

import java.time.LocalDate;

public class Plane extends Technic {

    private static final int LITER_PER_KM = 3;

    public Plane(int maxWeight, int maxPeople, int maxFuel, LocalDate productionDate, int currentWeight, int currentPeople, int currentFuel) {
        super(maxWeight, maxPeople, maxFuel, productionDate, currentWeight, currentPeople, currentFuel);
        this.construct();
    }

    @Override
    public void construct() {
        System.out.println("Plane has been constructed");
    }

    @Override
    public boolean travel(Place a, Place b) {
        if ((!super.travel(a, b)) || (!this.test()) || (!examineBeforeTravel(a, b))) {
            return false;
        }
        System.out.println("Has flown from place " + a + " to place " + b);
        return true;
    }

    @Override
    public boolean test() {
        boolean good = Math.random() > 0.01;
        if (!good) {
            System.out.println("The plane you have chosen is broken");
        }
        return good;
    }

    @Override
    public boolean examineBeforeTravel(Place a, Place b) {
        if (currentFuel() * LITER_PER_KM < Place.calculateDistance(a, b)) {
            System.out.println("There is not enough fuel in this plane. Pick another one...");
            return false;
        }
        return true;
    }
}
