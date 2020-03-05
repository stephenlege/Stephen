/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2_java3;

import java.util.*;

/**
 *
 * @author Greg
 */
public class Test2_java3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List l1 = new LinkedList();
        List l2 = new LinkedList();
        
        l1.add(1);
        l1.add(2);
        l1.add(5);
        
        l2.add(2);
        l2.add(3);
        l2.add(6);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println("----------------------------------------------");
        l1.addAll(l2);
        System.out.println(l1);
    }
    
}
