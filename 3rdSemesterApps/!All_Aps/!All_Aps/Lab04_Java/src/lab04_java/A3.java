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
public class A3 {

    int x;

    public A3() {
    }

    public A3(int x) {
        this.x = x;
    }

    public static Comparator<A3> comparatorReverse() {
        Comparator<A3> c = new Comparator<A3>() {
            @Override
            public int compare(A3 o1, A3 o2) {
                return o2.x - o1.x;
            }

        };
        return c;
    }

    public static Comparator<A3> comparator() {
        Comparator<A3> c = new Comparator<A3>() {
            @Override
            public int compare(A3 o1, A3 o2) {
                return o1.x - o2.x;
            }

        };
        return c;
    }

    @Override
    public String toString() {
        return "A1{" + "x=" + x + '}';
    }

    public static void main(String[] args) {
        System.out.println("Sorting in ascending order");
        List<A3> list1 = Arrays.asList(new A3(3), new A3(), new A3(2));

        Collections.sort(list1, A3.comparator());
        System.out.println(list1);

        System.out.println("Descending: ");
        Collections.sort(list1, A3.comparatorReverse());
        System.out.println(list1);

    }

}
