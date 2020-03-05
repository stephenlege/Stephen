/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2_java;

import java.util.ArrayList;

public class genericBinarySearch {

    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        //Basic binary search
        int low = 0;
        int high = list.length - 1;

        while (high >= low) {
            int mid = (low + high) / 2;
            if (key.compareTo(list[mid]) < 0) {
                high = mid - 1;
            } else if (key.equals(list[mid])) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.print("Key Not Found!!  ");
        return -1;
    }

    public static void main(String[] args) {
        //Integer [] list = {100, 50, 10, 1 , -10, -50, -100};
        Integer[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch(list, 1));
        System.out.println(binarySearch(list, 5));
        System.out.println(binarySearch(list, -100));
        System.out.println(binarySearch(list, 10));
    }

}
