package util;

public class CalculationMetaData {
    private final double n1;
    private final Sign sign;
    private final double n2;

    public CalculationMetaData(double n1, Sign sign, double n2) {
        this.n1 = n1;
        this.sign = sign;
        this.n2 = n2;
    }

    public double n1() {
        return n1;
    }

    public Sign sign() {
        return sign;
    }

    public double n2() {
        return n2;
    }
}
