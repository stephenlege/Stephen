package loops;

import java.math.BigInteger;


public class Exercise_05_26 {

    public static void main(String[] args) {
        double e = 1.0,
                value = 10000;

        // Compute e value for i = 20
        for (double i = 1; i <= value; i++) {
            //double denominator = i;
            BigInteger denominator = new BigInteger("1");
            for (double k = i - 1; k >= 1; k--) {
                denominator.multiply(new BigInteger(String.valueOf(k)));
            }
            e += 1 / denominator.doubleValue();
        }

        // Display result
        System.out.println("The e value for "+ value + " : " + e);

    }
}
