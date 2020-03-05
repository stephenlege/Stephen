/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory_generic_dao;

import java.util.Collection;

/**
 *
 * @author LEGE
 */
public class TestByShopping {
    public static void main(String[] args) {
        ShopingCart sp = new ShopingCart();
        
//        pfs.create(new Item("phone", "iphone1 serial number", "good"));
//        pfs.create(new Item("phone", "iphone2 serial number", "very good"));
//        pfs.create(new Item("phone", "android1 serial number", "very very good"));
//        pfs.create(new Item("computer", "HP serial number", "good PC"));
//        pfs.create(new Item("computer", "Macbook Pro serial number", "good laptop"));

        sp.addToCart(new Item("phone", "iphone1 serial number", "good"));
        sp.addToCart(new Item("phone", "iphone2 serial number", "very good"));
        sp.addToCart(new Item("computer", "PC serial", "good PC"));
        sp.addToCart(new Item("computer", "Laptop serial number", "good laptop"));
        sp.removeFromCart(new Item("computer", "Macbook Pro serial number", "good laptop"));
        
        System.out.println(sp.checkOut());
    }
    
    
    
}

class ShopingCart{
    FactoryStore fs = new FactoryStore<String, Keyable>();
    Product<Keyable> cart;
    
    public ShopingCart(){
        fs = new FactoryStore<String, Keyable>();
        cart = fs.createDao();
    }
    
    public void addToCart (Item item){
        this.cart.create(item);
    }
     public void addToCart (Item item, int qty){
        for(int i=0; i < qty; ++i){
            this.cart.create(item);
        }
    }
     public void removeFromCart(Item item){
         cart.delete(item);
     }
     
     public Collection<Keyable> checkOut(){
         cart.updateDBase();
         return cart.findAll();
     }
}
