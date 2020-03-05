/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

class XYZ<T1>
{
  ArrayList<? extends T1> list;//line 1
  public static <T2> void f ( ArrayList<? extends T2> list1)
      {
     System.out.println( list1.size());
    //list1.add( new Integer());//line 2
   }
public static void main(String[] args)
  {
   f( new ArrayList<Integer>() );//line 3
   f( new ArrayList<Object>() );//line 4
  f( new ArrayList<A>() ); //line 5
   }
}
//class A{}