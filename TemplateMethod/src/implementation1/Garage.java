package implementation1;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private final List<Technic> technicPool;

    public Garage() {
        technicPool = new ArrayList<>();
    }

    public void add(Technic technic) {
        technicPool.add(technic);
    }

    public void delete(Technic technic) {
        technicPool.remove(technic);
    }

    public Technic pickTechnic(int id) {
        if (id >= technicPool.size() || id < 0) {
            return null;
        }
        return technicPool.get(id);
    }

    public void show() {
        for (int i = 0; i < technicPool.size(); i++) {
            System.out.println(technicPool.get(i) + " [" + i + "]");
        }
    }
}
