/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generics;

public class GenericStack2<E> extends java.util.ArrayList<E> {
    //private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    public int getSize() {
        return this.size();
    }

    public E peek() {
        return this.get(getSize() - 1);
    }

    public void push(E o) {
        this.add(o);
    }

    public E pop() {
        E o = this.get(getSize() - 1);
        this.remove(getSize() - 1);
        return o;
    }
    public void clear(){
        this.removeAll(this);
    }
    
    
    public boolean isEmpty() {
        return (this.getSize() == 0);
    }

    @Override
    public String toString() {
        String stringList = "";
        for (int i = 0; i < getSize(); i++) {
            stringList += this.get(i) + " ";
        }
        return stringList;
    }

    public static <E> void print(E[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i] + "");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        GenericStack2<Integer> stackInt = new GenericStack2();
        GenericStack2<String> stackString = new GenericStack2();

        stackInt.push(0);
        stackInt.push(1);
        stackInt.push(2);

        stackString.push("Hello");
        stackString.push("World");

        System.out.println(stackInt);

        System.out.println(stackString);

        /**
         * Integer[] ar = new Integer[] {1,2,3};
        print(ar);
         */
        System.out.println("before pop: " + stackInt.peek());
        stackInt.pop();
        System.out.println("after pop: " + stackInt.peek());
        stackInt.pop();
        System.out.println("after pop: " + stackInt.peek());
        System.out.println(stackInt.isEmpty() + ", the stack is empty.");
        stackInt.clear();
        System.out.println("(.clear())");
        System.out.println(stackInt.isEmpty() + ", the stack is empty.");
    }
}
