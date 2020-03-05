package bl.singleton_dao_generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ProductsForSale<K, V extends Keyable>
        implements Product<Keyable>
{

    private Map<K, V> map = new HashMap<K, V>();

    @Override
    public void create(Keyable t)
    {
        map.put((K) t.getKey(), (V) t);
        // update database
    }

    @Override
    public void delete(Keyable t)
    {
        map.remove(t.getKey());
        //update database 
    }

    @Override
    public void update(Keyable t)
    {
        map.replace((K) t.getKey(), (V) t);
        //update database
    }

    @Override
    public Keyable find(Keyable t)
    {
        return map.get(t.getKey());
    }

    @Override

    public Collection<Keyable> findAll()
    {
        return (Collection<Keyable>) map.values();
    }

}
