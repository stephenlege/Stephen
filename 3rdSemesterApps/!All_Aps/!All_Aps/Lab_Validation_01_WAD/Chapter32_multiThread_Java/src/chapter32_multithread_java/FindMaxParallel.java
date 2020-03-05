/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter32_multithread_java;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author asdv
 */
public class FindMaxParallel {
    private static int count = 0;

    public static void main(String[] args) {
        // Create a list
        final int N = 9000000;
        int[] list = new int[N];
        for (int i = 0; i < list.length; i++) {
            list[i] = i + 1;
        }
        long startTime = System.currentTimeMillis();
        System.out.println("\nThe maximal number is " + max(list));
        long endTime = System.currentTimeMillis();
        System.out.println("Number of processors is "
                + Runtime.getRuntime().availableProcessors());
        System.out.println("Time with " + (endTime - startTime)
                + " milliseconds");
        
        
        startTime = System.currentTimeMillis();
        System.out.println("Not parrallel = " + maxNotParallel(list));
        endTime = System.currentTimeMillis();
        System.out.println("Time with " + (endTime - startTime)
                + " milliseconds");
        
        System.out.println("Number of Recursive Calls: " + count);

    }

    public static int maxNotParallel(int [] list){
        int max = 0;
        for (int i = 0; i < list.length; i++) {
                    if (list[i] > max) {
                        max = list[i];
                    }
                }
        return max;
    }
    public static int max(int[] list) {
        RecursiveTask<Integer> task = new MaxTask(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

    private static class MaxTask extends RecursiveTask<Integer> {

        private final static int THRESHOLD = 1000;
        private int[] list;
        private int low;
        private int high;

        public MaxTask(int[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        protected Integer compute() {
            //if array size is less than 1000, do linear traversal
            if (high - low < THRESHOLD) {
                int max = list[0];
                for (int i = low; i < high; i++) {
                    if (list[i] > max) {
                        max = list[i];
                    }
                }
                return new Integer(max);
                //keep cutting array in half and create recursive task
            } else {
                int mid = (low + high) / 2;
                RecursiveTask<Integer> left = new MaxTask(list, low, mid);
                RecursiveTask<Integer> right = new MaxTask(list, mid, high);

                //System.out.println(low + " " + high);
                count++;
                right.fork();
                left.fork();

                return new Integer(Math.max(left.join().intValue(),
                        right.join().intValue()));
            }
        }

    }

}
