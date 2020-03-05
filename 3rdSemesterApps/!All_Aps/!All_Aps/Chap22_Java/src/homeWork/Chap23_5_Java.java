/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeWork;

import chap23_java.Heap;
import java.util.Comparator;

/**
 *
 * @author Greg
 */
public class Chap23_5_Java {

    public static <E extends Comparable<E>> void heapSort(E[] list) {
        // Create a Heap 
        heapSort(list, (e1, e2) -> ((Comparable<E>) e1).compareTo(e2));
    }

    public static <E> void heapSort(E[] list, Comparator<? super E> c) {
        // Create a Heap 
        Heap<E> heap = new Heap(c);

        // Add elements to the heap
        for (int i = 0; i < list.length; i++) {
            heap.add(list[i]);
        }

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }

    public static void main(String[] args) {
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53, 3};
        heapSort(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println("");

        String[] list2 = {"Gary", "gari", "Testing", "Foster", "beer"};
        for (int i = 0; i < list2.length; i++) {
            System.out.print(list2[i] + " ");
        }
        System.out.println("\n");

        MyClass[] list3 = {new MyClass(100), new MyClass(-1), new MyClass(50)};
        for (int i = 0; i < list3.length; i++) {
            System.out.print(list3[i] + " ");
        }
        System.out.println("");
        heapSort(list3, new MyClassComparator());
        for (int i = 0; i < list3.length; i++) {
            System.out.print(list3[i] + " ");
        }
        System.out.println("");

    }
}
