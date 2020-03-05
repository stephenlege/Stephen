/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp2_java;

/**
 *
 * @author Greg
 */
public class linearSearch {
  
    
   public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
    for (int i = 0; i < list.length; i++)
      if (list[i].equals(key))
        return i;
    return -1;
  }
    public static void main(String[] args) {
        //String [] list = {"Hello", "hello", "never", "cthulu"};
        Integer[] list = {10, 8, 5, 1, -5, -8, -10};
        //returns index , if key is in list
        System.out.println(linearSearch(list,2));
        System.out.println(linearSearch(list, 5)); 
        System.out.println(linearSearch(list, 1)); 
    }
}
