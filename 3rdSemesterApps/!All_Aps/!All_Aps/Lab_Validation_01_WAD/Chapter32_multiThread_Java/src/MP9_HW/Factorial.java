/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP9_HW;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author Greg
 */
public class Factorial {
    private static final int THRESHOLD = 1;

    public static void main(String[] args) {

        int n = 10;

        long startTime = System.nanoTime();
        System.out.println("" + facParralel(n));
        long endTime = System.nanoTime();
        System.out.println("Time Was: " + (endTime - startTime)
                + " in nano time.");

        startTime = System.nanoTime();
        System.out.println(factorial(n));
        endTime = System.nanoTime();
        System.out.println("Time Was: " + (endTime - startTime)
                + " in nano time.");

    }

    public static int factorial(int n) {

        if (n >= 1) {
            return n * factorial(n - 1);
        } else {
            return 1;
        }
    }

    public static int facParralel(int n) {
        RecursiveTask<Integer> task = new FactorialTask(n);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);

    }

    static class FactorialTask extends RecursiveTask<Integer> {

        final int n;

        FactorialTask(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {

            if (n <= THRESHOLD) {
                return 1;
            }
            FactorialTask ft = new FactorialTask(n - 1);
            ft.fork();
            return n * ft.join();

        }

    }
}
