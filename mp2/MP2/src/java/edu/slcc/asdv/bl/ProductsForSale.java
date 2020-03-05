package edu.slcc.asdv.bl;

import edu.slcc.asdv.pojos.Item;
import edu.slcc.asdv.pojos.Keyable;
import edu.slcc.asdv.pojos.Product;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LEGE
 * @param <K>
 * @param <V>
 */
public class ProductsForSale<K, V extends Keyable>
        implements Product<Keyable>
{

    private Map<K, V> map = new HashMap<>();
    ConnectionEstablish con = new ConnectionEstablish();
    String message = "";
    Item item;

    /**
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     *
     * @param message 
     * Sets this.message to param
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @param t of type keyabe
     * Takes param and does a SQL insert statment 
     */
    @Override
    public void create(Keyable t)
    {
        map.put((K) t.getKey(), (V) t);
        item = (Item) map.get((K)t.getKey());
        try {
            ExecuteStatement.add(con, "INSERT INTO `inventory` (`itemId`, `itemName`, `itemDesc`, `qty`, `price`, `image`, `itemType`, `searchTerms`) VALUES "
                    + "('" + item.getId() + "', '" + item.getName() + "', '" + item.getDescription() + "', '" + item.getQty() + "', '" + item.getPrice()
                    + "', '" + item.getImage() + "', '" + item.getCategory() + "', '" + item.getSearch() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(ProductsForSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param t of type keyable
     * Takes param and performs a SQL delete stmt
     */
    @Override
    public void delete(Keyable t)
    {
        map.remove(t.getKey());
        item = (Item) map.get((K)t.getKey());
        try {
            DeleteData.delete(con, "DELETE FROM inventory WHERE itemId = '"  + item.getId() + "';");
        } catch (SQLException ex) {
            Logger.getLogger(ProductsForSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param t of type keyable
     * Takes param and performs a sql update stmt
     */
    @Override
    public void update(Keyable t)
    {
        map.replace((K) t.getKey(), (V) t);
        item = (Item) map.get((K)t.getKey());
        try {
            UpdateData.update(con, "UPDATE inventory SET itemName = '" + item.getName() + "', itemDesc = '" + item.getDescription() + "', qty = '" + item.getQty() + "', price = '" + item.getPrice()
                    + "', image = '" + item.getImage() + "', itemType = '" + item.getCategory() + "', searchTerms = '" + item.getSearch() + "' WHERE itemId = '" + item.getId() + "';");
        } catch (SQLException ex) {
            Logger.getLogger(ProductsForSale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param t
     * @return a Object of type keyable within this map
     */
    @Override
    public Keyable find(Keyable t)
    {
        return map.get(t.getKey());
    }

    /**
     *
     * @return a Map filled with all Keyables
     */
    @Override

    public Collection<Keyable> findAll()
    {
        return (Collection<Keyable>) map.values();
    }

    
    
}
