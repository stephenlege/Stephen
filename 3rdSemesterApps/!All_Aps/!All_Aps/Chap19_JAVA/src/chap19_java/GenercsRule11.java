/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap19_java;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Greg
 */
public class GenercsRule11 {
 public static <T> T f11(List<T> list){
     if (list.size()> 0)
         return list.get(0);
    return null;
 }
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("abc");
        f11(list1);
        System.out.println(list1.get(0));
        
        ArrayList<Integer> list2 = new ArrayList();
        list2.add(10);
        
        System.out.println(f11(list2));
        
        ArrayList<Double> list3 = new ArrayList();
        System.out.println(f11(list3));
    }
 
        
}
