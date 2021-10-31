package implementation1.util;

public class Place {
    private final double xCoordinate;
    private final double yCoordinate;
    private final double zCoordinate;

    public Place(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    public static double calculateDistance(Place a, Place b) {
        return Math.sqrt(Math.pow((a.xCoordinate - b.xCoordinate), 2) +
                Math.pow((a.yCoordinate - b.yCoordinate), 2) +
                Math.pow((a.zCoordinate - b.zCoordinate), 2));
    }

    @Override
    public String toString() {
        return "(" + xCoordinate + ", " + yCoordinate + ", " + zCoordinate + ")";
    }
}
