package util;

public enum Sign {
    MINUS, PLUS, MULTIPLY, DIVIDED_BY;

    public static boolean isSign(String sign) {
        return sign.equals("+") || sign.equals("-") || sign.equals("/") || sign.equals("*");
    }

    public static Sign stringToSign(String sign) {
        if (isSign(sign)) {
            return switch (sign) {
                case "+" -> PLUS;
                case "-" -> MINUS;
                case "*" -> MULTIPLY;
                default -> DIVIDED_BY;
            };
        }
        return null;
    }
}
