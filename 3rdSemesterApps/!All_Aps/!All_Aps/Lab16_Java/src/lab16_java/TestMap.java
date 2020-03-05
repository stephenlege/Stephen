package lab16_java;

import java.util.*;

public class TestMap {
  public static void main(String[] args) {
    // Create a HashMap
    Map<String, Integer> hashMap = new HashMap<>();
    hashMap.put("Smith", 30);
    hashMap.put("Anderson", 31);
    hashMap.put("Lewis", 29);
    hashMap.put("Cook", 29);

    System.out.println("Display entries in HashMap");
    System.out.println(hashMap + "\n");

    // Create a TreeMap from the preceding HashMap
    Map<String, Integer> treeMap = new TreeMap<>(hashMap);
    System.out.println("Display entries in ascending order of key");
    System.out.println(treeMap);

    // Create a LinkedHashMap
    Map<String, Integer> linkedHashMap =
      new LinkedHashMap<>(16, 0.75f, true);
    linkedHashMap.put("Smith", 20);
    linkedHashMap.put("Anderson", 21);
    linkedHashMap.put("Lewis", 19);
    linkedHashMap.put("Cook", 19);

    // Display the age for Lewis
    System.out.println("\nThe age for " + "Lewis is " +
      linkedHashMap.get("Lewis"));
    //linkedHashMap.get("Cook");

    System.out.println("Display entries in LinkedHashMap");
    System.out.println(linkedHashMap);
    
    // Display each entry with name and age
    System.out.print("\n--TreeMap for each--- Names and ages are " );
    treeMap.forEach(
      (name, age) -> System.out.print(name + ": " + age + " "));
    
      System.out.print("\n--LinkedHashMap for each--- Names and ages are ");
      linkedHashMap.forEach((name, age) -> 
              System.out.print(name + ": " + age + " "));
      
      System.out.print("\n--HashMap for each--- Names and ages are ");
      hashMap.forEach((name, age) -> 
              System.out.print(name + ": " + age + " "));
      
      System.out.println();
  }
}
