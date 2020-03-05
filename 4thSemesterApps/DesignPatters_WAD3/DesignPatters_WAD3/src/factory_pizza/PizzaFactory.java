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
public class PizzaFactory {
    
    public static Pizza createPizza(String type){
        Pizza p = null;
        
        if(type.toLowerCase().equals("cheese"))
            p = new CheesePizza();
        else if(type.toLowerCase().equals("chicken"))
            p = new ChickenPizza();
        else if (type.toLowerCase().equals("veggie"))
            p = new VeggiePizza();
        
        return p;
    }
    
}
