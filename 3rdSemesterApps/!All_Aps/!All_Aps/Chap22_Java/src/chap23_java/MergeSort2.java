/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap23_java;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort2 {

    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        if (list.length > 1) {
            // Merge sort the first half
            E[] firstHalf = (E[]) new Comparable[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            // Merge sort the second half
            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = (E[]) (new Comparable[secondHalfLength]);
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            // Merge firstHalf with secondHalf into list
            merge(firstHalf, secondHalf, list);
        }
    }

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

    public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {

        if (list.length > 1) {

            E[] firstHalf = Arrays.copyOf(list, list.length / 2);
            mergeSort(firstHalf, comparator);

            E[] secondHalf = Arrays.copyOfRange(list, list.length / 2, list.length);
            mergeSort(secondHalf, comparator);

            merge(firstHalf, secondHalf, list, comparator);
        }
    }

    public static <E> void merge(E[] list1, E[] list2, E[] temp,
            Comparator<? super E> comparator) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            if (comparator.compare(list1[current1], list2[current2]) < 0) {
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

    public static void main(String[] args) {
        Integer[] intArray = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

        String[] stringArray = {"Gary", "gari", "Testing", "Foster", "beer"};

        mergeSort(intArray);
        printList(intArray);

        mergeSort(stringArray);
        printList(stringArray);
        
        

    }

    
    public static void printList(Object[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

}
