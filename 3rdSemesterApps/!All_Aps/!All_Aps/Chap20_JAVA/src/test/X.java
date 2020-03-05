/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

public class X
{
   public static void f1(ArrayList<?> list)//1
    {
    System.out.println( list.size());//2
    //list.add(new Integer( 5));//3
   }

   public static void main(String[] args)
   {
    f1(new ArrayList<Integer>());//4
    f1(new ArrayList<Double>());//5
   }
}