/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory_generic_dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LEGE
 */
public class FactoryStore<K, V extends Keyable> extends Factory<Keyable> {

    private Map<K, V> map = new HashMap<K, V>();

    @Override
    public Product<Keyable> createDao() {
        
        return new Product<Keyable>() {
            @Override
            public void create(Keyable t) {
                map.put((K) t.getKey(), (V) t);
            }

            @Override
            public void delete(Keyable t) {
                map.remove(t.getKey());
            }

            @Override
            public void update(Keyable t) {
                map.replace((K) t.getKey(), (V) t);
            }

            @Override
            public Keyable find(Keyable t) {
                return map.get(t.getKey());
            }

            @Override
            public Collection<Keyable> findAll() {
                return (Collection<Keyable>) map.values();
            }

            @Override
            public boolean updateDBase() {
                //update the singleton of available products
                //OR the database if there is no singleton
                return true;
            }

        };
    }

}
