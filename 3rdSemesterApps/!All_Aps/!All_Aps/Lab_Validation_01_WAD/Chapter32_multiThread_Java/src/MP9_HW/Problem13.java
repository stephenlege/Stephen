/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP9_HW;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author Greg
 */
public class Problem13 {

    public static void main(String[] args) {
        final int SIZE = 100000;
        Integer[] list1 = new Integer[SIZE];
        Integer[] list2 = new Integer[SIZE];

        for (int i = 0; i < list1.length; i++) {
            list1[i] = list2[i] = (int) (Math.random() * 10000000);
        }

        long startTime = System.currentTimeMillis();
        parallelMergeSort(list1);
        long endTime = System.currentTimeMillis();
        System.out.println("\nParallel time with " + Runtime.getRuntime().availableProcessors() + " processors is " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        MergeSort.mergeSort(list2);
        endTime = System.currentTimeMillis();
        System.out.println("\nSequential time is " + (endTime - startTime) + " milliseconds");
    }

    public static <E extends Comparable<E>> void parallelMergeSort(E[] list) {
        RecursiveAction mainTask = new SortTask<E>(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    private static class SortTask<E extends Comparable<E>> extends RecursiveAction {

        private static final long serialVersionUID = 1L;
        private final int THRESHOLD = 500;
        private E[] list;

        SortTask(E[] list) {
            this.list = list;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void compute() {
            if (list.length < THRESHOLD) {
                java.util.Arrays.sort(list);
            } else {
                // Obtain the first half
                E[] firstHalf = (E[]) (new Comparable[list.length / 2]);
                System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

                // Obtain the second half
                int secondHalfLength = list.length - list.length / 2;
                E[] secondHalf = (E[]) (new Comparable[secondHalfLength]);
                System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);

                // Recursively sort the two halves
                invokeAll(new SortTask<E>(firstHalf), new SortTask<E>(secondHalf));

                // Merge firstHalf with secondHalf into list
                MergeSort.merge(firstHalf, secondHalf, list);
            }
        }
    }

    static class MergeSort {

        @SuppressWarnings("unchecked")
        public static <E extends Comparable<E>> void mergeSort(E[] list) {
            if (list.length > 1) {

                E[] firstHalf = (E[]) (new Comparable[list.length / 2]);
                System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
                mergeSort(firstHalf);

                int secondHalfLength = list.length - list.length / 2;
                E[] secondHalf = (E[]) (new Comparable[secondHalfLength]);
                System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
                mergeSort(secondHalf);

                merge(firstHalf, secondHalf, list);
            }
        }

        /**
         * Merge two sorted lists
         */
        public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {
            int current1 = 0;
            int current2 = 0;
            int current3 = 0;

            while (current1 < list1.length && current2 < list2.length) {
                if (list1[current1].compareTo(list2[current2]) < 0) {
                    temp[current3++] = list1[current1++];
                } else {
                    temp[current3++] = list2[current2++];
                }
            }

            while (current1 < list1.length) {
                temp[current3++] = list1[current1++];
            }

            while (current2 < list2.length) {
                temp[current3++] = list2[current2++];
            }
        }
    }
}
