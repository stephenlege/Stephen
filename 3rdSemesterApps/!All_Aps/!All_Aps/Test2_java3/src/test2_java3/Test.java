/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2_java3;


import java.util.*;

public class Test {
  public static void main(String[] args) throws Exception {
    TreeSet<String> set = new TreeSet<>();
    
    set.add("Red");
    set.add("Yellow");
    set.add("Green");
    set.add("Blue");
    SortedSet temp = set.tailSet("Purple");
    
    System.out.println(temp);
  }
}
