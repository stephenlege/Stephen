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
public class GreatestCommonD {

    
        public static int gcd(int n1, int n2)
    {
        if (n2 != 0)
            return gcd(n2, n1 % n2);
        else
            return n1;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1 = 0;
        int n2 = 0;
        System.out.println("Enter two numbers to find their GCD");
        n1 = input.nextInt();
        n2 = input.nextInt();
        
        
        System.out.println("The GCD of " + n1 + " and " + n2 + " are: " + gcd(n1, n2));
        
    }
    
}
