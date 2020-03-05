/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ar114
 */
public class NestedForPatternC {

    public static void main(String[] args) {
        int i = 1;
        //int j = 6;      cause loop to only run once

        while (i <= 6) {
            int j = 6;         //j needs to start here for each outside itteration
            while (j >= 1) {
                //need to nest an if to get spaces before numbers
                // 1st nested loop needs to be FALSE 5 times
                //require two white spaces for else because 1 is for number spot
                //and the second is for the regular space you get from j + " "
                System.out.print((j <= i) ? j + " " : " " + " ");

                j--;
            }

            System.out.println();
            i++;        //just like in a for loop, increment is done @ loops end
        }
    }

}
