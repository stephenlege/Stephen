/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04_java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author Greg
 */
public class A1 implements Comparable<A1>{
    int x;
    public A1(){}
    public A1(int x) {this.x = x;}

    @Override
    public int compareTo(A1 o) {
        return this.x - o.x;
    }

    @Override
    public String toString() {
        return "A1{" + "x=" + x + '}';
    }
     public static void main(String[] args) {
         System.out.println("Sorting in ascending order");
         List<A1> list1 = Arrays.asList(new A1(3), new A1(), new A1(2));
         
         Collections.sort(list1);
         System.out.println(list1);
         
         System.out.println("Sorting in decending order");
         Collections.sort(list1, Collections.reverseOrder());
         
         System.out.println(list1);
         
    }
    
}
