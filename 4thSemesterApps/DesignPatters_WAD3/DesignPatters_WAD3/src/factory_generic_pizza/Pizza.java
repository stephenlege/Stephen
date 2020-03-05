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
public interface Pizza<T> {
    
    public void prepare(T t);
    
    public void bake(T t);
    
    public void cut(T t);
    
}
