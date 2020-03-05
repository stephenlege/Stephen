/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter27_hashing_java;

public class TestMyHashSet {
  public static void main(String[] args) {
    // Create a MyHashSet
    java.util.Collection<String> set = new MyHashSet<>();
    set.add("Smith");
    set.add("Anderson");
    set.add("Lewis");
    set.add("Cook");
    set.add("Smith"); // Add Smith to set

    System.out.println("Elements in set: " + set);
    System.out.println("Number of elements in set: " + set.size());
    System.out.println("Is Smith in set? " + set.contains("Smith"));

    set.remove("Smith");
    System.out.print("Names in set in uppercase are ");
    for (String s: set)
      System.out.print(s.toUpperCase() + " ");

    set.clear();
    System.out.println("\nElements in set: " + set);
  }
}
