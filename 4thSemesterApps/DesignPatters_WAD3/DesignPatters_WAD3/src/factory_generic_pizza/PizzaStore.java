/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory_generic_pizza;

/**
 *
 * @author LEGE
 */
public class PizzaStore<T> {
    public Pizza<T> orderPizza(T t){
        Pizza<T> pizza = PizzaFactory.createPizza(t);
        pizza.prepare(t);
        pizza.bake(t);
        pizza.cut(t);
        
        return pizza;
    }
    
}
