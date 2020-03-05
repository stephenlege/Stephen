/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Greg
 */
public class TestPyramid {

    public static void main(String[] args) {
        
            int number = 1;
            int rows = 8;
            int space = rows - 1;
 
            for (int i = 1; i <= rows; i++) {
                for (space = 1; space <= (rows - i); space++) {
                    System.out.print("  ");
                }
 
                for (int j = 1; j <= i; j++) {
                    System.out.print(number + "    ");
                    
                    if (j == 1)
                        number = 1;
                    else 
                        number = (int)Math.pow(2,j);
                }
 
                for (int k = (i - 1); k >= 1; k--) {
                    System.out.print(number + "    ");
                    number = (int)Math.pow(2,k );
                }
 
                System.out.println();
 
            }
        } 
    }
