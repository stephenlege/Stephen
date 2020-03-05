/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04_java;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Greg
 */
public class A2 {

    int x;

    public A2() {
    }

    public A2(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "A1{" + "x=" + x + '}';
    }

    public static void main(String[] args) {
        System.out.println("Sorting in ascending order");
        List<A2> list1 = Arrays.asList(new A2(3), new A2(), new A2(2));

        Comparator<A2> c = new Comparator<A2>() {
            @Override
            public int compare(A2 o1, A2 o2) {
                return o1.x - o2.x;
            }
        };

        Collections.sort(list1, c);
        System.out.println(list1);
        Comparator<A2> rev = new Comparator<A2>() {
            @Override
            public int compare(A2 o1, A2 o2) {
                return o2.x - o1.x;             
            }

        };
         
        Collections.sort(list1, rev);
        System.out.println(list1);

    }

}
