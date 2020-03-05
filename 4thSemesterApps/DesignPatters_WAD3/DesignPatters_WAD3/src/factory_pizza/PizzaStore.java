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
public class PizzaStore {
    
    public Pizza orderPizza(String type){
    Pizza p = PizzaFactory.createPizza(type);
    p.prepare();
    p.bake();
    p.cut();
    
    return p;
    
}}
