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
public class IntegerReverse {

    public static void reverse(int num) {
        if (num != 0) {
            System.out.print(num % 10);
            num = num / 10;
            reverse(num);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an number to display its reversal: ");
        int num = input.nextInt();

        reverse(num);
        System.out.println("");

    }

}
