/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AA1

{

   public static void x( List<? extends A> list){}

   public static void main(String[] args)
      {

       ArrayList<B> list2 = new ArrayList();//1

       //list1.add(new A());//2

       x( list2 );//3
       
          System.out.println(list2);
          
          Comparable <Date> c = new Date();
          
          //Comparable <?> c = new Date();
          
          //Comparable <String> c = new Date();
          
          //Comparable <E> c = new Date();

  }

}

 class A{}
 class B extends A{}
 class C extends B{}