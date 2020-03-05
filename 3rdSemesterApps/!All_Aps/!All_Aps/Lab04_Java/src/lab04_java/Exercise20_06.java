/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab04_java;

import java.util.LinkedList;
import javafx.geometry.Point2D;

/**
 *
 * @author Greg
 */
public class Exercise20_06 {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        for (int i = 0; i < 5000000; i++) {
            list.add(i);
        }
        /**
        long startTime = System.currentTimeMillis();
        
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long endTime = System.currentTimeMillis();
        
        System.out.println("Time using get: " + (endTime - startTime));
        
        */
        int x;
        long startTime = System.currentTimeMillis();

        for (int i : list) {
            x = i;
        }
        long endTime = System.currentTimeMillis();
        
        System.out.println("time using itterator:  " + (endTime - startTime));
        
    }
}
