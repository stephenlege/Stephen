/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

/**
 *
 * @author Greg
 */
public class GenericStack1<E> {

    private int capacity = 3;
    private E[] list = (E[]) new Object[capacity];
    private int topOfStack = -1;

    public int getSize() {
        return topOfStack + 1;
    }

    /**public E[] reSet(){
        E[] listTemp = (E[]) new Object[capacity];
        for(int i = 0; i < list.length; i++){
            listTemp[i]=list[i];
        }
        clear();
        for(int i = 0; i < listTemp.length -1; i++)
            list[i] = listTemp[i];
        return list;
        
    }*/
    
    public E peek() {
        return list[topOfStack];
    }

    public void push(E o) {
        list[++topOfStack] = o;
        

    }

    public E pop() {
        E o = list[topOfStack--];
        //clear();
        return o;
    }
    
 

    public boolean isEmpty() {
       return (topOfStack == -1);
    }

    public void clear() {
        list = null;
        topOfStack=-1;
            
    }

    @Override
    public String toString() {
        String stringList = "";
        for (int i = 0; i < getSize() ; i++) {
            stringList += list[i];
        }
        return stringList;

    }

    public static void main(String[] args) {
        GenericStack1<Integer> stackInt = new GenericStack1();
        GenericStack1<String> stackString = new GenericStack1();

        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);
        System.out.println(stackInt);

        stackString.push("a");
        stackString.push("b");
        stackString.push("c");
        System.out.println(stackString);

        System.out.println(stackInt.peek());

        stackInt.pop();
        System.out.println("Int peek(after pop): " + stackInt.peek());
        
        stackString.pop();
        System.out.println("String peek(after pop): " + stackString.peek());

        System.out.println(stackInt);
        stackInt.clear();
       
        System.out.println("Is it Empty? " + stackInt.isEmpty());
    }
}
