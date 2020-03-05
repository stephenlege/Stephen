/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01java;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 *
 * @author Greg
 */
public class testSerialization {

    public static void testSerialization()
            throws IOException, ClassNotFoundException {

        try (
                ObjectOutputStream output = new ObjectOutputStream(
                        new FileOutputStream("testSerialization.dat"));) {
            for (int i = 0; i <3; ++i){
                C[] arC = new C[] {new C(), new C(), new C()};
                output.writeObject(arC);
                output.writeObject(new java.util.Date());
                output.writeDouble(5.5);
                output.writeObject("Loop Iteration" + (i + 1) + " is done.");
            }
        }
        
        try (
                ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(
                    new FileInputStream("testSerialization.dat")));)
        {
            while (true){
                C [] cAr = (C[]) input.readObject();
                
                for(C c: cAr){
                    for(int i = 0; i < c.arrayList.size();++i)
                        System.out.println(c.arrayList.get(i));
                }
                
                Date date = (Date) input.readObject();
                System.out.println(date);
                
                double d = input.readDouble();
                System.out.println(d);
                
                String loop = (String) input.readObject();
                System.out.println(loop);
                
            }
        }
        catch (EOFException ex){
            System.out.println("EOF occured as expected");
        }
        
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        testSerialization();
    }
}
