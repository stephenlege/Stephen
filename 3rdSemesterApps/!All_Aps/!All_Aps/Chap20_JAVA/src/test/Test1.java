/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

public class Test1
 {

   public static void main(String args[])
     {
     G<Integer> m = new G<Integer>();
     // m.set("merit");
     System.out.println(m.get());
    }
 }

class G<T>
 {

  T var;

   void set(T var){ this.var = var;}

T get() { return var; }
}