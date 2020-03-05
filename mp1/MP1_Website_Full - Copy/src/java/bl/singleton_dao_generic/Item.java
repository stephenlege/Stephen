package bl.singleton_dao_generic;

import java.util.Objects;

public class Item
        implements Keyable<String>, Comparable<Item>, Categorable<String> {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    public String id;
    public String itemName;
    public String description;
    public String imageLink;
    public double price;
    public String type;
    public String searchTerms;
    public int qty;
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    /*returns qty*/
    public int getQty() {
        return qty;
    }

    /*sets qty*/
    public void setQty(int qty) {
        this.qty = qty;
    }

    /*returns search terms*/
    public String getSearchTerms() {
        return searchTerms;
    }

    /*sets search terms*/
    public void setSearchTerms(String searchTerms) {
        this.searchTerms = searchTerms;
    }

    /*returns type*/
    public String getType() {
        return type;
    }

    /*sets type*/
    public void setType(String type) {
        this.type = type;
    }

    /*returns price*/
    public double getPrice() {
        return price;
    }

    /*sets price*/
    public void setPrice(double price) {
        this.price = price;
    }

    /*returns imageLink*/
    public String getImageLink() {
        return imageLink;
    }

    /*sets image link*/
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    /*return description*/
    public String getDescription() {
        return description;
    }

    /*sets description*/
    public void setDescription(String description) {
        this.description = description;
    }

    /*returns itemName*/
    public String getItemName() {
        return itemName;
    }

    /*sets ItemName*/
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /*returns id*/
    public String getId() {
        return id;
    }

    /*sets id*/
    public void setId(String id) {
        this.id = id;
    }
    //</editor-fold>

    public Item() {
    }

    public Item(String id, String itemName, String description, String imageLink, double price, String type, String searchTerms, int qty) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.imageLink = imageLink;
        this.price = price;
        this.type = type;
        this.searchTerms = searchTerms;
        this.qty = qty;
    }

    @Override
    public String getKey() {
        return getId();
    }

    @Override
    public void setKey(String key) {
        setKey(key);
    }


    @Override
    public int compareTo(Item o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", itemName=" + itemName + ", description=" + description + ", imageLink=" + imageLink + ", price=" + price + ", type=" + type + ", searchTerms=" + searchTerms + ", qty=" + qty + '}';
    }

    @Override
    public String getCategory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCategory(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
