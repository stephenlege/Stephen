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
public class PizzaFactory {

    public static <T> Pizza<T> createPizza(T t) {
        return new Pizza<T>() {
            @Override
            public void prepare(T t) {
                System.out.println("Preparing Pizza " + t.toString() + ".");
            }

            @Override
            public void bake(T t) {
                System.out.println("Baking Pizza "+ t.toString() + ".");
            }

            @Override
            public void cut(T t) {
                System.out.println("Baking Pizza "+ t.toString() + ".");
            }

        };

    }

}
