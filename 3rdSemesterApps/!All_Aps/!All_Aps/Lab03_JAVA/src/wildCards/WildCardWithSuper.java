/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildCards;

import generics.GenericStack;

/**
 *
 * @author Greg
 */
public class WildCardWithSuper {

    public static <T> void add(GenericStack<T> stack1, GenericStack<? super T> stack2) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public static void main(String[] args) {
        generics.GenericStack<String> stack1 = new generics.GenericStack<>();
        generics.GenericStack<Object> stack2 = new generics.GenericStack<>();
        
        stack2.push("one");
        stack2.push(2);
        stack2.push("one");
        stack2.push(123);
        
        stack1.push("nope");
        stack1.push("haha");
        stack1.push("and another");
        
        add(stack1, stack2);
        WildCard2.print(stack2);
    }
}
