/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homeWork;

/**
 *
 * @author Greg
 */
public class TestHeap {
    public static void main(String[] args) throws CloneNotSupportedException {
        
        Integer [] h1 = {1,2,3,4,5};
        Integer [] h2 = {6,7,8,9,10};
        
        Heap <Integer> heap = new Heap<>(h1);
        
        
        Heap<Integer>  heap2 = new Heap<>(h2);
      
        
       Heap<Integer> heap3 = (Heap)heap2.clone();
       
        
        System.out.println("h1 equals h2: " + heap.equals(heap2));
        System.out.println("h2 equals h3: " + heap2.equals(heap3));
        
    }
}
