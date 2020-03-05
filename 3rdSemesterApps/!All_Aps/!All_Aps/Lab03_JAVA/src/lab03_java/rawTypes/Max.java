/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03_java.rawTypes;


/**
 *
 * @author Greg
 */
public class Max {
    public static Comparable max(Comparable o1, Comparable o2){
        if (o1.compareTo(o2) > 0)
            return o1;
        else
            return o2;
    }
    
    public static <E extends Comparable<E>> E maxSafe(E e1, E e2){
        if (e1.compareTo(e2) > 0)
            return e1;
        else
            return e2;
    }
    public static void main(String[] args) {
        System.out.println(max(1,2));
        System.out.println();
        try{
            System.out.println(maxSafe(1,2));
            System.out.println(maxSafe("abc", "ABC"));
            //System.out.println(maxSafe(1,"two"));
            
            generics.GenericStack stackUnsafe = new generics.GenericStack();
            generics.GenericStack<Integer> stackSafe = new generics.GenericStack();
            stackSafe.push(1); stackSafe.push(2);
            System.out.println(stackSafe);
            System.out.println("This line compiles but crashes " 
            + max(1,"two"));
        }catch(ClassCastException e){
            System.out.println("RAW TYPES ARE UNSAFE " + e.getMessage());
        }
    }
}
