/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04_java;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Greg
 */
public class testPriorityQueue {
    
    
    public static void main(String[] args) {
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        
        queue1.offer("Oklahoma");
        queue1.offer("Indiana");
        queue1.offer("Georgia");
        queue1.offer("Texas");
        System.out.println("Priority queue using Comparable: ");
        
        System.out.println("Before Remove: " + queue1);
        
        for (int i = 0; i < 6; i++)
            System.out.println(queue1.poll());
        //while (queue1.size() > 0)
            //ystem.out.println(queue1.remove() + " ");
        
        System.out.println("\nIs que empty? " + queue1 + " " + queue1.isEmpty());
        
        
        Comparator<String> c = Collections.reverseOrder();
        PriorityQueue<String> queue2 = new PriorityQueue<>(4,c);
        queue2.offer("Oklahoma");
        queue2.offer("Indiana");
        queue2.offer("Georgia");
        queue2.offer("Texas");
        
        
        
        System.out.println("\n\nPriority queue using Comparator:");
        while(queue2.size() > 0)
            System.out.println(queue2.remove() + " ");
        
    }
}
