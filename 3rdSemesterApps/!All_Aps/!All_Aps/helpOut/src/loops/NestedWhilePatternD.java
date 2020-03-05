/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ar114
 */
public class NestedWhilePatternD {

    public static void main(String[] args) {
        //state variables
        //i needed to be set to zero, was trying 1
        int i = 0, j = 1;

        //nested loops (while) book made 3 fors?
        //for third while use patternB nestedFor loop
        while (i <= 6) {             //this loop will run the rows
            i++;
            j = i;
            while (j > 1) {         //this loop will determine spaces b4 numbers
                System.out.print("  ");     //needs to be FALSE for 1st run (no spaces)
                j--;
            }
            j = 1;
            while (j <= 7 - i) {            //final loop to print numbers
                System.out.print(j + " ");  //1st run must be TRUE for every itteration

                j++;
            }
            System.out.println();
        }

    }
}
