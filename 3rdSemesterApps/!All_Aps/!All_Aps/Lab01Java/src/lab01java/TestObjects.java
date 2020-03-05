/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01java;

import java.io.*;

public class TestObjects {

    public static void main(String[] args)
            throws ClassNotFoundException, IOException {

        try ( // Create an output stream for file object.dat
                ObjectOutputStream output
                = new ObjectOutputStream(new FileOutputStream("test1.dat"));) {

            int[] intValues = {1, 2, 3, 4, 5};
            double doubleValue = 5.5;

            // Write a string, double value, and object to the file
            output.writeObject(intValues);
            output.writeObject(new java.util.Date());
            output.writeDouble(doubleValue);
        }

        try ( // Create an input stream for file array.dat
                ObjectInputStream input
                = new ObjectInputStream(new FileInputStream("test1.dat"));) {
            int[] newIntValues = (int[]) (input.readObject());

            // Display arrays
            for (int i = 0; i < newIntValues.length; i++) {
                System.out.print(newIntValues[i] + " ");
            }
            System.out.println("");
            java.util.Date date = (java.util.Date) (input.readObject());
            Double newDoubleValue = (double) (input.readDouble());
            System.out.println(date);
            System.out.println(newDoubleValue);
        }
    }
}
