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
public class Bin2DecRecursion {

    public static int bin2Dec(String binary, int zero) {
        //base
        int n = binary.length();
        if (zero == n - 1) {
            return binary.charAt(zero) - '0';
        }

        return ((binary.charAt(zero) - '0')
                << (n - zero - 1)) + bin2Dec(binary, zero + 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String binary = "";

        System.out.println("Enter binary number to convert to decimal: ");
        binary = input.next();

        System.out.println(bin2Dec(binary, 0));
    }
}
