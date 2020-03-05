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
public class Dec2HexRecursion {
    
     public static char dec2HexC(int decimal) {
    if (decimal >= 10 && decimal <=15)
      return (char)('A' + decimal - 10);
    else 
      return (char)('0' + decimal);
  }
    
     public static String dec2Hex(int decimal) {
    if (decimal == 0)
      return "";
    else {
      return dec2Hex(decimal / 16) + dec2HexC(decimal % 16);   
    }
  }
  
public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a decimal integer to convert it to hex: ");
    int decimal = input.nextInt();
    
    System.out.println(dec2Hex(decimal));
  }  

 
}

