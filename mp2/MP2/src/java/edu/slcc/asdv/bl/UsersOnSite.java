package edu.slcc.asdv.bl;

import edu.slcc.asdv.pojos.Item;
import edu.slcc.asdv.pojos.Keyable;
import edu.slcc.asdv.pojos.Product;
import edu.slcc.asdv.pojos.User;
import edu.slcc.asdv.utilities.DESUtil;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersOnSite<K, V extends Keyable>
        implements Product<Keyable> {

    private Map<K, V> map = new HashMap<>();
    ConnectionEstablish con = new ConnectionEstablish();
    String message = "";
    User user;

    /**
     *Getter
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     *Setter
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @param t is a key
     * takes t and runs a sql insert statement
     */
    @Override
    public void create(Keyable t) {
        try {
            System.out.println("Trying");
            map.put((K) t.getKey(), (V) t);
            user = (User) map.get((K) t.getKey());
            System.out.println(user);
            ExecuteStatement.add(con, "INSERT INTO `users` (`email`, `password`, `type`) VALUES ('" + user.getUserEmail() + "', '" + user.getUserPass() + "', '" + user.getCategory() + "');");
        } catch (SQLException ex) {
            Logger.getLogger(UsersOnSite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     * @param t is a key
     * takes t and runs a sql delete statement
     */
    @Override
    public void delete(Keyable t) {
        map.remove(t.getKey());
        user = (User) map.get((K) t.getKey());
        try {
            DeleteData.delete(con, "DELETE FROM inventory WHERE email = '" + user.getUserEmail() + "';");
        } catch (SQLException ex) {
            Logger.getLogger(UsersOnSite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param t is a key
     * takes the key and runs a sql update statement
     */
    @Override
    public void update(Keyable t) {
        map.replace((K) t.getKey(), (V) t);
        user = (User) map.get((K) t.getKey());
        try {
            UpdateData.update(con, "UPDATE inventory SET email = '" + user.getUserEmail() + "', password = '" + user.getUserPass() + "', type = '"
                    + user.getCategory() + "WHERE email = '" + user.getUserEmail() + "';");
        } catch (SQLException ex) {
            Logger.getLogger(UsersOnSite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param t takes a keyable as an arg
     * @return keyable object from the map that matches t
     */
    @Override
    public Keyable find(Keyable t) {
        return map.get(t.getKey());
    }

    /**
     *
     * @return map of all keyable objects
     */
    @Override

    public Collection<Keyable> findAll() {
        return (Collection<Keyable>) map.values();
    }

}
