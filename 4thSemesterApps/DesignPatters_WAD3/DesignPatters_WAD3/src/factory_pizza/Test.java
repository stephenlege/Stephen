/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory_pizza;

import java.util.Scanner;

/**
 *
 * @author LEGE
 */
public class Test {
    public static void main(String[] args) {
        PizzaStore ps = new PizzaStore();
        String order1= "";
        Scanner input = new Scanner(System.in);
        
        
        System.out.println("Enter a Pizza type: ");
        order1 = input.next();
        
        ps.orderPizza(order1);
        
        
    }
}
