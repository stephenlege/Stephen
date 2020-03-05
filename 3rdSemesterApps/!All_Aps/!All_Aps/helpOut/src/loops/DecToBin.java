/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class DecToBin {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a decimial interger: ");
        int decimal = input.nextInt();

        // Convert the decimal number to a binary number
        String binary = "";	

        for (int i = decimal; i > 0; i /= 2) {
            binary = (i % 2) + binary;
        }

        System.out.println(
                "The binary value of the decimial \"" + decimal + "\" is: " + binary);
    }

}
