/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HWList;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Greg
 */
public class Triangle {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();
        
        map.put("john", 20);
         map.put("mary", 18);
          map.put("aaron", 19);
          
          Set<Entry<String,Integer>> entries = map.entrySet();
          Set<String> keys = map.keySet();
          Collection<Integer> values = map.values();
          
          System.out.println(map);
          
          System.out.println("abc".hashCode() + " " + "cba".hashCode());
          System.out.println("---------------------------------------------");
          
          for(String key: keys)
            System.out.println(key.hashCode());
          
          keys.remove("john");
          System.out.println(map);
            
    }
}
