package util;

public class VariableGenerator {
    public static String next(String variable) {
        if (variable.matches(".*\\d+")) {
            return variable.replaceAll("\\d+$", String.valueOf(Integer.parseInt(variable.replaceAll(".*\\D", "")) + 1));
        } else {
            return variable + "1";
        }
    }
}
