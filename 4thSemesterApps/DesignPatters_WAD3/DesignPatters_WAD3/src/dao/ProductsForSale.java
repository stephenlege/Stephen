/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LEGE
 */
public class ProductsForSale<K, V extends KeyedProduct> implements Product<KeyedProduct> {
    private Map<K, V> map = new HashMap<K, V>();

    @Override
    public void create(KeyedProduct kp) {
        map.put((K) kp.getKey(), (V) kp);
    }

    @Override
    public void delete(KeyedProduct t) {
        map.remove(t); //update database
    }

    @Override
    public void update(KeyedProduct t) {
        map.replace((K) t.getKey(), (V) t);
    }

    @Override
    public KeyedProduct find(KeyedProduct t) {
        return map.get(t.getKey());
    }

    @Override
    public Collection<KeyedProduct> findAll() {
        return (Collection<KeyedProduct>) map.values();
    }
    
    
    public static void main(String[] args) {
        ProductsForSale<String, KeyedProduct> productsForSale = new ProductsForSale();
        
        productsForSale.create(new Phone("iphone1", "good"));
        productsForSale.create(new Phone("iphone2", "very good"));
        productsForSale.create(new Phone("android1", "very very good"));
        
        productsForSale.create(new Computer(1, "PC"));
        Collection<KeyedProduct> c = productsForSale.findAll();
        System.out.println(c);
        Phone phone = new Phone("iphone2", "bad, very bad");
        
        productsForSale.update(phone);
        
        System.out.println(productsForSale.find(phone));
        productsForSale.delete(phone);
        System.out.println(productsForSale.findAll());
    }
    
}
