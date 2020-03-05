/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2_java;

import java.util.ArrayList;

/**
 *
 * @author Greg
 */
public class genericALMax {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(4000);
        list.add(1);
        list.add(2);
        list.add(101);

        System.out.print(max(list));
        System.out.println("");
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        E currentMax = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (currentMax.compareTo(list.get(i)) < 0) {
                currentMax = list.get(i);
            }
        }

        return currentMax;
    }
}
