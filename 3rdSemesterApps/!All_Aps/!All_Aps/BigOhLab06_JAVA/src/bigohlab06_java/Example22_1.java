/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigohlab06_java;

import java.util.LinkedList;
import java.util.Scanner;

public class Example22_1 {
    
    private static Scanner input = new Scanner(System.in);
    private static LinkedList<Character> max = new LinkedList<>();
    private static LinkedList<Character> list = new LinkedList<>();
    
    public static void sub1(){
        System.out.print("Enter a string: ");
        String string = input.nextLine();
        for (int i = 0; i < string.length(); i++) { 		
            if (list.size() > 1 && string.charAt(i) <= list.getLast()
                    && list.contains(string.charAt(i))) {
                list.clear(); 
            }
            list.add(string.charAt(i)); 
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
        } 
    }

    public static void main(String[] args) {

        sub1();
        for (Character ch : max) { 
            System.out.print(ch); 
        }
        System.out.println();
    }}
