/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2_java;

import java.util.ArrayList;
//import java.util.Collections;

/**
 *
 * @author Greg
 */
public class arrayListSort {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(100);
        list.add(1000);
        list.add(1);
        list.add(2);
        list.add(101);

        sortAL(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("");

        //Collections.sort(list);
        //System.out.print(list);
    }

    public static <E extends Comparable<E>> void sortAL(ArrayList<E> list) {

        E temp;//create current min value based on type E

        for (int i = 0; i < list.size()-1; i++) {
           
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

    }
}
