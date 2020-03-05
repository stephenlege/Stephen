/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildCards;

import generics.GenericStack;
import static wildCards.WildCard.max;

/**
 *
 * @author Greg
 */
public class WildCard2 {

    public static void print(GenericStack<?> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " ");
        }

    }

    public static void main(String[] args) {

        generics.GenericStack<Integer> intStack = new generics.GenericStack<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(-2);
        //System.out.println("The max number is " + max(intStack));
        System.out.println(intStack);
    }
}
