package edu.slcc.asdv.pojos;

public class Product {

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

    /*to string method*/
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", itemName=" + itemName + ", description=" + description + ", imageLink=" + imageLink + ", price=" + price + ", type=" + type + ", searchTerms=" + searchTerms + ", qty=" + qty + '}';
    }

}
