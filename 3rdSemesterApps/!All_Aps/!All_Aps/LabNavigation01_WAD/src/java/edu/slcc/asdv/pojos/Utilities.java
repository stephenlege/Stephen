/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.pojos;

import java.util.Random;

/**
 *
 * @author Greg
 */
public class Utilities {
    
    private static Random r = new Random();
    
    public static int randomInt(int range){
        return r.nextInt(range);
    }
    
    public static int randomIndex(Object [] array){
        return randomInt(array.length);
    }
    public static <T> T randomElement(T[] array){
        return array[randomIndex(array)];
    }
}
