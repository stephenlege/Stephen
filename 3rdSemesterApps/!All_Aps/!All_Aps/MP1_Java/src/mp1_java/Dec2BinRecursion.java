/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1_java;

import static java.lang.Integer.parseInt;
import java.util.Scanner;


/**
 *
 * @author Greg
 */
public class Dec2BinRecursion {
    public static String dec2Bin(int decimal) 
    { 
        if (decimal == 0)  
            return "0";  
        else
            return "" + (decimal % 2 + 10 * (parseInt(dec2Bin(decimal / 2)))); 
    } 
      
    
    
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a decimal integer to convert it to binary ");
    int decimal = input.nextInt();
    
    System.out.println(dec2Bin(decimal));
  }  
}
