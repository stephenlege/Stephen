package bl.singleton_dao_generic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ASDV2
 */
public class WarehouseSingleton<K, V extends Keyable>

{
    private static ProductsForSale<String, Keyable> productsForSale;
    private static WarehouseSingleton warehouse;

    private WarehouseSingleton()
    {
        productsForSale = new ProductsForSale();

    }

    public static WarehouseSingleton instantiateWarehouse()
    {
        if (warehouse == null)
          {
            warehouse = new WarehouseSingleton();
          }

        return warehouse;
    }

    public static ProductsForSale<String, Keyable> getProducts()
    {
        return productsForSale;
    }

    public static void main(String[] args)
    {
        WarehouseSingleton ws = WarehouseSingleton.instantiateWarehouse();
        ProductsForSale<String, Keyable> pfs = ws.getProducts();
//        pfs.create(new Item("phone", "iphone1 serial number", "good"));
//        pfs.create(new Item("phone", "iphone2 serial number", "very good"));
//        pfs.create(new Item("phone", "android1 serial number", "very very good"));
//        pfs.create(new Item("computer", "HP serial number", "good PC"));
//        pfs.create(new Item("computer", "Macbook Pro serial number", "good laptop"));
//        Collection<Keyable> c = pfs.findAll();
//        System.out.println(c);
//        Item item = new Item("phone", "iphone2 serial number", "bad, very bad");
//        pfs.update(item);
//        System.out.println(pfs.find(item));
//        pfs.delete(item);
//        System.out.println(pfs.findAll());
    }

}
