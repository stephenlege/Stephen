/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wildCards;

/**
 *
 * @author Greg
 */
public class NoWildCard {
    public static double max(generics.GenericStack<Number> stack){
        double max = -888;
        while (!stack.isEmpty()){
            double value = stack.pop().doubleValue();
            if(value > max)
                max = value;
            
        }
        return max;
    }
    public static void main(String[] args) {
        
    generics.GenericStack<Integer> intStack = new generics.GenericStack<>();
    intStack.push(1);
    intStack.push(2);
    intStack.push(-2);
        //System.out.println("The max number is " + max(intStack));
    }
}
