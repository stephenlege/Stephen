/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LEGE
 */
public class ItemsForSale {

    private List<String> itemsForSale;
    private static ItemsForSale it;

    //private constructor
    private ItemsForSale() {
        //get items from database
        itemsForSale = new ArrayList<String>();
        itemsForSale.add("Phone1");
        itemsForSale.add("Phone2");
        itemsForSale.add("Computer1");
        itemsForSale.add("Computer2");
    }
    public static ItemsForSale getItemsForSale(){
        if (it == null){
            it = new ItemsForSale();
        }
        return it;
    }
    public List<String> get(){
        return itemsForSale;
    }
    public String buy(String s){
        for(String product : itemsForSale)
            if(s.equals(product))
                return s;
        return null;
    }
    
    
    public static void main(String[] args) {
        ItemsForSale ifs = ItemsForSale.getItemsForSale();
        
        List<String> forSale = ifs.get();
        
        System.out.println(forSale);
        
        System.out.println(ifs.buy("Phone1"));
        
    }
}
