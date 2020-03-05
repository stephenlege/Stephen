/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1_java;

import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class largestNumber {
    
    public static int largestRecursion(int [] ar, int n){
        if (n == 1) 
        return ar[0]; 
        
    return Math.max(ar[n-1], largestRecursion(ar, n-1)); 
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] ar = new int [8];
        
        System.out.println("Enter 8 integers:");
        for (int i = 0; i < ar.length; i++)
            ar[i] = input.nextInt();
        
        System.out.println("The largest int is: " + largestRecursion(ar, ar.length));
    }
}
