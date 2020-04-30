import java.util.*;

public class Main {

    public static int convert(Double val) {
        if(val.equals(Double.NaN)) {
            return 0;
        } else if(val.equals(Double.POSITIVE_INFINITY)) {
            return Integer.MAX_VALUE;
        } else if(val.equals(Double.NEGATIVE_INFINITY)) {
            return Integer.MIN_VALUE;
        } else {
            double valDouble = val;
            int valInt = (int) valDouble;
            return valInt;
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double doubleVal = new Double(scanner.nextDouble() / scanner.nextDouble());
        System.out.println(convert(doubleVal));
    }
}