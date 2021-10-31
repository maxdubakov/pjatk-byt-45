package implementation1;

import implementation1.reading.ConsoleReader;
import implementation1.reading.Reader;
import implementation1.util.Place;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Garage garage = initializeGarage();
        Reader reader = new ConsoleReader();
        int pick = 0;

        garage.show();
        while (pick != -1) {
            System.out.print("Please, pick a technic to travel (-1 to quit): ");
            pick = reader.readInt();
            Technic technic = garage.pickTechnic(pick);

            int[] p1 = new int[3];
            System.out.println("Please, enter place from you are going:");
            System.out.print("X: ");
            p1[0] = reader.readInt();
            System.out.print("\nY: ");
            p1[1] = reader.readInt();
            System.out.print("\nZ: ");
            p1[2] = reader.readInt();

            int[] p2 = new int[3];
            System.out.println("Please, enter place where you are going:");
            System.out.print("X: ");
            p2[0] = reader.readInt();
            System.out.print("\nY: ");
            p2[1] = reader.readInt();
            System.out.print("\nZ: ");
            p2[2] = reader.readInt();

            technic.travel(new Place(p1[0], p1[1], p1[2]), new Place(p2[0], p2[1], p2[2]));
        }
    }

    public static Garage initializeGarage() {
        Garage garage = new Garage();
        garage.add(new Car(10000, 10, 300, LocalDate.now(), 1000 ,1, 100, true));
        garage.add(new Car(20000, 20, 300, LocalDate.now(), 2000 ,1, 200, false));
        garage.add(new Car(30000, 30, 300, LocalDate.now(), 3000 ,1, 250, true));
        garage.add(new Car(40000, 40, 300, LocalDate.now(), 4000 ,1, 300, true));
        garage.add(new Car(50000, 50, 300, LocalDate.now(), 5000 ,1, 200, false));
        garage.add(new Plane(100000, 200, 2000, LocalDate.now(), 40000 ,1, 100));
        garage.add(new Plane(200000, 300, 3000, LocalDate.now(), 50000 ,1, 1000));
        garage.add(new Plane(300000, 400, 4000, LocalDate.now(), 60000 ,1, 100));
        garage.add(new Plane(400000, 500, 5000, LocalDate.now(), 70000 ,1, 500));

        return garage;
    }
}
