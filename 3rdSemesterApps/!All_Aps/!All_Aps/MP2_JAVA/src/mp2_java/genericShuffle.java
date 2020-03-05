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
public class genericShuffle {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(20);
        list.add(300);
        list.add(4);
        list.add(5000);
        shuffle(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println("");
        System.out.println(list);
        System.out.println("");
    }

    public static <E> void shuffle(ArrayList<E> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int index = (int) (Math.random() * list.size());
            E temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }
    }
}
