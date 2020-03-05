/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP9_HW;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class Factorial2 extends RecursiveTask<BigInteger> {

    final int end;
    final int start;
    private static final int THRESHOLD = 10;
    

    public static void main(String[] args) {
         int n = 20;

         Factorial2 fact = new Factorial2(n);
        long startTime = System.nanoTime();
        System.out.println((fact.computeDirectly()));
        long endTime = System.nanoTime();
        System.out.println("Time Was: " + (endTime - startTime)
                + " in nano time.");

    }
    public Factorial2(int n) {
        this(1, n + 1);
    }

    private Factorial2(int start, int end) {
        this.start = start;
        this.end = end;
    }

   
    
    

    @Override
    protected BigInteger compute() {
        if (end - start < THRESHOLD) {
            return computeDirectly();
        } else {
            int mid = (start + end) / 2;
            Factorial2 lower = new Factorial2(start, mid);
            lower.fork();
            Factorial2 upper = new Factorial2(mid, end);
            BigInteger upperVal = upper.compute();
            return lower.join().multiply(upperVal);
        }
    }

    private BigInteger computeDirectly() {
        BigInteger val = BigInteger.ONE;
        BigInteger mult = BigInteger.valueOf(start);
        for (int iter = start; iter < end; iter++, mult = mult.add(BigInteger.ONE)) {
            val = val.multiply(mult);
        }
        return val;
    }
}
