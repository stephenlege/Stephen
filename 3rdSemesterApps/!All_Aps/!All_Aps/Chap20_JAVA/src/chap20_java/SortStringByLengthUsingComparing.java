/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chap20_java;

import java.util.*;

public class SortStringByLengthUsingComparing {
  public static void main(String[] args) {
    Loan[] list = {new Loan(5.5, 10, 100), new Loan(5, 10, 1000)};
    Arrays.sort(list, Comparator.comparing(Loan::getLoanAmount).
        reversed());


    
    
    String[] cities = {"Atlanta", "Savannah", "New York", "Dallas"};
    java.util.Arrays.sort(cities, 
        Comparator.comparing(String::length));

    for (String s : cities) {
      System.out.print(s + " ");
    }
  }

  public static class MyComparator implements
      java.util.Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      return s1.length() - s2.length();
    }
  }
}