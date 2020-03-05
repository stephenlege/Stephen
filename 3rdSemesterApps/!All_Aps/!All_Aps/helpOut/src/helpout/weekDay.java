/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpout;

import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class weekDay {
    public static void main(String[] args) {
        System.out.println("Enter a day: ");
        Scanner input = new Scanner(System.in);
        String day =input.next().toLowerCase();
        
        if(day.equals("sunday"))
            System.out.println("1");
        else
            System.out.println("Wrong day!");
    }
 
}
