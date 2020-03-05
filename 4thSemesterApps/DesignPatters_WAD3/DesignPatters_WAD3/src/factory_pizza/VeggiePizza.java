/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory_pizza;

/**
 *
 * @author LEGE
 */
public class VeggiePizza implements Pizza {
     @Override
    public void prepare() {
        System.out.println("Preparing  Veggie Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Veggie Pizza");
    }

    @Override
    public void cut() {
        System.out.println("Cutting Veggie Pizza");
        }
}
