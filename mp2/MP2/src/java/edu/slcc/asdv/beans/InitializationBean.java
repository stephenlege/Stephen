/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.bl.ProductsForSale;
import edu.slcc.asdv.bl.UsersOnSite;
import edu.slcc.asdv.bl.UsersSingleton;
import edu.slcc.asdv.bl.WarehouseSingleton;
import edu.slcc.asdv.pojos.Item;
import edu.slcc.asdv.pojos.Keyable;
import edu.slcc.asdv.pojos.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Destroyed;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;

/**
 *
 * @author micha
 */
@Named(value = "initBean")
@ApplicationScoped
public class InitializationBean {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    private static WarehouseSingleton ws;
    ProductsForSale<String, Keyable> pfs;
    private static UsersSingleton us;
    Collection<Keyable> itemCollection;
    Collection<Keyable> userCollection;
    List<Item> itemList = new ArrayList<>();
    DefaultMenuModel compMenu = new DefaultMenuModel();
    DefaultMenuModel mobileMenu = new DefaultMenuModel();
    DefaultSubMenu laptops = new DefaultSubMenu("Laptops");
    DefaultSubMenu desktops = new DefaultSubMenu("Desktops");
    DefaultSubMenu phones = new DefaultSubMenu("Phones");
    DefaultSubMenu tablets = new DefaultSubMenu("Tablets");

    //</editor-fold>
    /**
     *
     * @param init controlls initialization
     * @throws SQLException
     */
    public void in(@Observes @Initialized(ApplicationScoped.class) Object init) throws SQLException {
        System.out.println("Initializing singletons");
        ws = WarehouseSingleton.instantiateWarehouse();
        us = UsersSingleton.instantiateUsers();
        pfs = ws.getProducts();
        itemCollection = pfs.findAll();
        addToMenu();
    }

    //<editor-fold defaultstate="collapsed" desc="Setters/Getters">
    /**
     *
     * @return ws
     */
    public static WarehouseSingleton getWarehouse() {
        return ws;
    }

    /**
     *
     * @return us
     */
    public static UsersSingleton getUsers() {
        return us;
    }

    /**
     * destroys object
     *
     * @param init
     */
    public void destroy(@Observes @Destroyed(ApplicationScoped.class) Object init) {
    }

    /**
     * default constructer
     */
    public InitializationBean() {
    }

    /**
     *
     * @return pfs
     */
    public ProductsForSale<String, Keyable> getPfs() {
        return pfs;
    }

    /**
     * Setter
     *
     * @param pfs
     */
    public void setPfs(ProductsForSale<String, Keyable> pfs) {
        this.pfs = pfs;
    }

    public void setCompMenu(DefaultMenuModel compMenu) {
        this.compMenu = compMenu;
    }

    public void setMobileMenu(DefaultMenuModel mobileMenu) {
        this.mobileMenu = mobileMenu;
    }

    public void setLaptops(DefaultSubMenu laptops) {
        this.laptops = laptops;
    }

    public void setDesktops(DefaultSubMenu desktops) {
        this.desktops = desktops;
    }

    public void setPhones(DefaultSubMenu phones) {
        this.phones = phones;
    }

    public void setTablets(DefaultSubMenu tablets) {
        this.tablets = tablets;
    }

    public DefaultMenuModel getCompMenu() {
        return compMenu;
    }

    public DefaultMenuModel getMobileMenu() {
        return mobileMenu;
    }

    public DefaultSubMenu getLaptops() {
        return laptops;
    }

    public DefaultSubMenu getDesktops() {
        return desktops;
    }

    public DefaultSubMenu getPhones() {
        return phones;
    }

    public DefaultSubMenu getTablets() {
        return tablets;
    }
    //</editor-fold>

    /**
     * Adds an item to a list from the Collection
     */
    public void listItems() {
        itemCollection.forEach(item -> {
            itemList.add((Item) item);
        });
    }

    /**
     * Adds names to the Tiered Menu
     */
    public void addToMenu() {
        listItems();

        for (int i = 0; i < itemList.size(); ++i) {
            Item temp = itemList.get(i);
            DefaultMenuItem menuItem = new DefaultMenuItem(temp.getName());
            String key = temp.getId();
            menuItem.setCommand("#{function.menuChangeItem}");
            menuItem.setParam("id" + i, key);
            switch (temp.getCategory()) {
                case "laptop":
                    laptops.addElement(menuItem);
                    break;
                case "desktop":
                    desktops.addElement(menuItem);
                    break;
                case "phone":
                    phones.addElement(menuItem);
                    break;
                case "tablet":
                    tablets.addElement(menuItem);
                    break;
            }
        }
        compMenu.addElement(laptops);
        compMenu.addElement(desktops);
        mobileMenu.addElement(phones);
        mobileMenu.addElement(tablets);
    }

}
