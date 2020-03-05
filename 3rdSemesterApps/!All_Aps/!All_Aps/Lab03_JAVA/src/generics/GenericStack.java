/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

public class GenericStack<E> {
  private java.util.ArrayList<E> list = new java.util.ArrayList<>();

  public int getSize() {
    return list.size();
  }

  public E peek() {
    return list.get(getSize() - 1);
  }

  public void push(E o) {
    list.add(o);
  }

  public E pop() {
    E o = list.get(getSize() - 1);
    list.remove(getSize() - 1);
    return o;
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }
  
  @Override
  public String toString() {
    return "stack: " + list.toString();
  }
  
  public static <E> void print(E[] list){
      for (int i = 0; i < list.length; i++){
          System.out.println(list[i] + "");
      }
      System.out.println("");
  }
  
    public static void main(String[] args) {
        GenericStack<Integer> stackInt = new GenericStack();
        GenericStack<String> stackString = new GenericStack();
        
        stackInt.push(0);
        stackInt.push(1);
        stackInt.push(2);
        
        stackString.push("Hello");
        stackString.push("World");
        
        System.out.println(stackInt);
        
        System.out.println(stackString);
        
        Integer[] ar = new Integer[] {1,2,3};
        print(ar);
    }
}
