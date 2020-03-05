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
public class RadoLetts {
    public static void main(String[] args) {
        System.out.println("" + (char)('A' + (int)(Math.random() * 26)));
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter 3 numbers to sort");
        int x = input.nextInt();
        int y = input.nextInt();
        int z = input.nextInt();
        
        int min = Math.min(x, (Math.min(y, z)));
        int mid = (x < y && y < z)? y: (x > z && x < y)? x: z;
        int max = Math.max(x, (Math.max(y, z)));
        
        System.out.println(""+ min + " " + mid + " " + max );
    }
}
