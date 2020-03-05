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
public class A4<E extends Comparable<E>> {

    E x;

    public A4(E x) {
        this.x = x;
    }

  

    public static Comparator<A4> comparatorReverse() {
        Comparator<A4> c = (A4 a1, A4 a2) -> a2.x.compareTo(a1.x);
        return c;
    }

    public static Comparator<A4> comparator() {
        Comparator<A4> c = (A4 a1, A4 a2) -> a1.x.compareTo(a2.x);
        return c;
    }

    @Override
    public String toString() {
        return "A4{" + "x=" + x + '}';
    }

    

    public static void main(String[] args) {
        System.out.println("Sorting in ascending order");
        List<A4> list1 = Arrays.asList(
                new A4(new Integer(4)), 
                new A4(new Integer(1)), 
                new A4(new Integer(2)));

        Collections.sort(list1, A4.comparator());
        System.out.println(list1);
        
        
        List<A4> list2 = Arrays.asList(
                            new A4(new String("once")),
                            new A4(new String("upon")),
                            new A4(new String("a")),
                            new A4(new String("time")),
                            new A4(new String("in")),
                            new A4(new String("America"))
        );
        Collections.sort(list2,A4.comparator());
        System.out.println(list2);
        
        System.out.println("Descending: ");
        Collections.sort(list1, A4.comparatorReverse());
        System.out.println(list1);
        
        Collections.sort(list2, A4.comparatorReverse());
        System.out.println(list2);
    }

}
