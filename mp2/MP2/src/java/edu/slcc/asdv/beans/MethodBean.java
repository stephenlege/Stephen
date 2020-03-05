/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.bl.ProductsForSale;
import edu.slcc.asdv.bl.ReloadPage;
import edu.slcc.asdv.bl.UsersOnSite;
import edu.slcc.asdv.bl.UsersSingleton;
import edu.slcc.asdv.bl.WarehouseSingleton;
import edu.slcc.asdv.pojos.Item;
import edu.slcc.asdv.pojos.Keyable;
import edu.slcc.asdv.pojos.User;
import edu.slcc.asdv.utilities.DESUtil;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.MenuItem;

/**
 *
 * @author stephen
 */
@Named(value = "function")
@SessionScoped
public class MethodBean implements Serializable {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    //better to just work with WarehouseSingleton
    Collection<Keyable> items;
    Collection<Keyable> users;
    
    WarehouseSingleton ws;
    UsersSingleton us;
    static ProductsForSale<String, Keyable> p;
    static UsersOnSite<String, Keyable> u;
    List<Item> itemList = new ArrayList<>();
    List<User> userList = new ArrayList<>();
    List<Item> buyList = new ArrayList<>();
    Item currentItem;
    User currentUser;
    String loadTemplate = "template/default/contentDefault.xhtml";
    String login = "template/notLoggedIn.xhtml";
    String email;
    String password;
    String searchTerm;
    Map<String, String> searchResults = new LinkedHashMap<>();
    List<String> keyList = new ArrayList<>();
    //</editor-fold>

    /**
     *public constructor
     */
    public MethodBean() {
        ws = InitializationBean.getWarehouse();
        us = InitializationBean.getUsers();
        p = ws.getProducts();
        u = us.getUsers();
        items = p.findAll();
        users = u.findAll();
    }

    //<editor-fold defaultstate="collapsed" desc="Setters/Getters">
    public String getSearchTerm() {
        return searchTerm;
    }

    public List<String> getKeyList() {
        return keyList;
    }

    public void setKeyList(List<String> keyList) {
        this.keyList = keyList;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public Map<String, String> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(Map<String, String> searchResults) {
        this.searchResults = searchResults;
    }

    public Item getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(Item currentItem) {
        this.currentItem = currentItem;
    }

    public List<Item> getBuyList() {
        return buyList;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Collection<Keyable> getItems() {
        return items;
    }

    public void setItems(Collection<Keyable> items) {
        this.items = items;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLoadTemplate() {
        return loadTemplate;
    }

    public void setLoadTemplate(String loadTemplate) {
        this.loadTemplate = loadTemplate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //</editor-fold>

    /**
     *makes a list of each item
     */
    
    public void listItems() {
        items.forEach(item -> {
            itemList.add((Item) item);
        });
    }

    /**
     *creates a list of each user
     */
    public void listUsers() {
        users.forEach(user -> {
            userList.add((User) user);
        });
    }

    /**
     *
     * @param event takes user action event to load the <content>
     * @throws java.io.IOException
     */
    public void menuChangeItem(MenuActionEvent event) throws IOException {
        MenuItem menuItem = event.getMenuItem();
        Object[] keys = menuItem.getParams().keySet().toArray();
        String key = keys[0].toString();
        String id = menuItem.getParams().get(key).get(0);
        currentItem = (Item) p.find(new Item(id));
        loadTemplate = "template/product.xhtml";
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/index.xhtml");
    }

    /**
     *
     * @param id finds current item 
     * and goes to the next 
     * @throws IOException
     */
    public void changeItem(String id) throws IOException {
        currentItem = (Item) p.find(new Item(id));
        loadTemplate = "template/product.xhtml";
        System.out.println("Changing Changing....");
        FacesContext.getCurrentInstance().getExternalContext().redirect("faces/index.xhtml");
        //FacesContext context = FacesContext.getCurrentInstance().;
        //ReloadPage.reloadPage(context);
    }

    /**
     *method that goes to the next product when user presses button
     * @throws IOException
     */
    public void nextProduct() throws IOException {
        listItems();
        for (int i = 0; i < itemList.size(); ++i) {
            if (itemList.get(i).getId().equals(currentItem.getId())) {
                Item item1 = itemList.get(i);
                for (int j = i + 1; j <= itemList.size(); ++j) {
                    if (j != i && j < itemList.size()) {
                        Item item2 = itemList.get(j);
                        if (item1.getCategory().equals(item2.getCategory())) {
                            changeItem(item2.getId());
                            return;
                        } else {
                            continue;
                        }
                    } else if (j == itemList.size()) {
                        j = -1;
                    } else {
                        changeItem(currentItem.getId());
                        return;
                    }
                }
            }
        }
    }

    /**
     *Method that goes to previous Product when the user presses a button
     * @throws IOException
     */
    public void previousProduct() throws IOException {
        listItems();
        for (int i = itemList.size() - 1; i > 0; --i) {
            if (itemList.get(i).getId().equals(currentItem.getId())) {
                Item item1 = itemList.get(i);
                for (int j = i - 1; j >= 0; --j) {
                    if (j != i && j > 0) {
                        Item item2 = itemList.get(j);
                        if (item1.getCategory().equals(item2.getCategory())) {
                            changeItem(item2.getId());
                            return;
                        } else {
                            continue;
                        }
                    } else if (j == 0) {
                        j = itemList.size() - 1;
                    } else {
                        changeItem(currentItem.getId());
                        return;
                    }
                }
            }
        }
    }

    /**
     *Allows user to login to database
     * @throws IOException
     */
    public void loginToSite() throws IOException {
        System.out.println(email + " " + password);
        FacesContext context = FacesContext.getCurrentInstance();
        if (u.find(new User(email)) != null) {
            User temp = (User) u.find(new User(email));
            String pass = DESUtil.decrypt(temp.getUserPass());
            System.out.println(pass);
            if (pass.equals(password)) {
                login = "template/loggedIn.xhtml";
                context.getExternalContext().redirect("home.xhtml");
                return;
            }
        }
        loadTemplate = "template/register.xhtml";
        context.getExternalContext().redirect("index.xhtml");
    }

    /**
     *Allows user to register to DataBase
     * @throws IOException
     */
    public void register() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        u.create(new User(email, DESUtil.encrypt(password), "user"));
        currentUser = (User) u.find(new User(email));
        loadTemplate = "template/default/contentDefault.xhtml";
        context.getExternalContext().redirect("home.xhtml");
    }

    /**
     *Adds to a buylist, used for cart later
     */
    public void buy() {
        buyList.add(currentItem);
    }

    /**
     *removes from cart
     * @param id of current item
     */
    public void remove(String id) {
        buyList.remove(new Item(id));
    }

    /**
     *
     * returns a map of items that matches the users search
     * @throws IOException
     * @throws SQLException
     */
    public void search() throws IOException, SQLException {
        searchResults.clear();
        listItems();
        System.out.println("SearchTerm: ============== " + searchTerm);
        System.out.println(itemList);
//        itemList.forEach(p -> {
//            if (searchTerm.toLowerCase().trim().matches(p.searchTerms)) {
//                searchResults.put(p.getId(), p.getName());
//                System.out.println("Lets Sout searchResults: -------- " + searchResults);
//            }
//        });

        for(int i = 0; i < itemList.size();i++){
            Item item = itemList.get(i);
            System.out.println(item.getSearch());
            if (searchTerm.toLowerCase().trim().matches(item.getSearch())) {
                searchResults.put(item.getId(), item.getName());
                System.out.println("Lets Sout searchResults: -------- " + searchResults);
           }
        }
        keyList = new ArrayList<>(searchResults.keySet());
        FacesContext.getCurrentInstance().getExternalContext().redirect("search.xhtml");
    }
}
