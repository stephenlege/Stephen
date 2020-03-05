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
 * @author asdv
 */
public class FibonacciTask {

    public static void main(String[] args) {

        int n = 20;

        long startTime = System.currentTimeMillis();
        System.out.println("" + fibParallel(n));
        long endTime = System.currentTimeMillis();
        System.out.println("Time Was: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        System.out.println(fib(n));
        endTime = System.currentTimeMillis();
        System.out.println("Time Was: " + (endTime - startTime));
    }

    public static int fib(int n) {

        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static int fibParallel(int n) {
        RecursiveTask<Integer> task = new Fibonacci(n);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);

    }

    static class Fibonacci extends RecursiveTask<Integer> {

        final int n;

        Fibonacci(int n) {
            this.n = n;
        }

        @Override
        protected Integer compute() {

            if (n <= 1) {
                return n;
            }

            Fibonacci f1 = new Fibonacci(n - 1);
            f1.fork();
            Fibonacci f2 = new Fibonacci(n - 2);
            return f2.compute() + f1.join();

        }

    }
}

/*
private static class FibTask extends RecursiveTask>Integer>{
int fib;
public FibTask(
 */
