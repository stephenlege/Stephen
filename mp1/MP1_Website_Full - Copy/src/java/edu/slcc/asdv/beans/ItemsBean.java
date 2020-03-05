/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.pojos.Product;
import edu.slcc.asdv.utilities.Database;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;

@Named(value = "itemsBean")
@SessionScoped
public class ItemsBean implements Serializable {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    ArrayList<Product> products = new ArrayList<>();

    ArrayList<String> list = new ArrayList<>();

    static int index = 0;

    String curProduct;
    String curDesc;
    String curImage;
    double curPrice;
    int curQty;

    String searchTerm;
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public List<String> getKeyList() {
        return keyList;
    }

    public void setKeyList(List<String> keyList) {
        this.keyList = keyList;
    }

    public String getSearchTerm() {
        return searchTerm;
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

    public String getCurProduct() {
        return curProduct;
    }

    public void setCurProduct(String curProduct) {
        this.curProduct = curProduct;
    }

    public String getCurDesc() {
        return curDesc;
    }

    public void setCurDesc(String curDesc) {
        this.curDesc = curDesc;

    }

    public String getCurImage() {
        return curImage;
    }

    public void setCurImage(String curImage) {
        this.curImage = curImage;
    }

    public double getCurPrice() {
        return curPrice;
    }

    public void setCurPrice(double curPrice) {
        this.curPrice = curPrice;

    }

    public int getCurQty() {
        return curQty;
    }

    public void setCurQty(int curQty) {
        this.curQty = curQty;
    }

    private static Connection connection() //throws InstantiationException, IllegalAccessException
    {

        String databaseName = "woohoo_computers";
        String userName = "root";
        String password = "";
        String URL2 = "com.mysql.cj.jdbc.Driver";
        //String URL2 = "com.mysql.cj.jdbc.Driver";
        Connection con = null;
        try {// Load Sun's jdbc driver
            Class.forName(URL2).newInstance();
            System.out.println("JDBC Driver loaded!");
        } catch (Exception e) // driver not found
        {
            System.err.println("Unable to load database driver");
            System.err.println("Details : " + e);
            return null;
        }
        String ip = "localhost"; //internet connection
        String url = "jdbc:mysql://" + ip + ":3308/" + databaseName;
        try {
            con = DriverManager.getConnection(url, userName, password);
            con.setReadOnly(false);
        } catch (Exception e) {
            System.err.println(e.toString());
            return null;
        }
        System.out.println("connection successfull");
        return con;
    }

    // </editor-fold>
    /*pulls all products from the database and stores them in a list*/
    
    
    public void getAllProducts() throws SQLException {
        
        Connection con = Database.con;
        
        /*> 
        print error msg if connection to database can't be established
         */
        if (con == null) {
            System.out.println("Cannot connect to database");
            return;
        } else {
            /*>
            If connected, store products into a list, 
            along with the id in  a seperate list
             */
            try {
                Statement stmt = Database.con.createStatement();
                ResultSet result = stmt.executeQuery("Select * FROM inventory");
                ResultSetMetaData rsmd = result.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                while (result.next()) {
                    for (int i = 1; i <= columnsNumber;) {
                        Product product = new Product();
                        product.id = result.getString(i);
                        i++;
                        product.itemName = result.getString(i);
                        i++;
                        product.description = result.getString(i);
                        i++;
                        product.qty = result.getInt(i);
                        i++;
                        product.price = result.getDouble(i);
                        i++;
                        product.imageLink = result.getString(i);
                        i++;
                        product.type = result.getString(i);
                        i++;
                        product.searchTerms = result.getString(i);
                        i++;
                        products.add(product);
                        list.add(product.id);
                    }
                }
            } finally {
                Database.con.close();
            }
        }
    }

    /*Map that stores serachREsults*/
    Map<String, String> searchResults = new LinkedHashMap<>();

    /*List that stores the keys*/
    List<String> keyList = new ArrayList<>();

    /*Method that takes the search input from the user
      and see if it matches and regex stored in the database*/
    public void search() throws IOException, SQLException {
        searchResults.clear();
        products.forEach((p) -> {
            if (searchTerm.toLowerCase().matches(p.searchTerms)) {
                searchResults.put(p.id, p.itemName);
            }
        });
        keyList = new ArrayList<>(searchResults.keySet());
        FacesContext.getCurrentInstance().getExternalContext().redirect("search.xhtml");
    }

    /*Method that goes to the next product in the list*/
    public void nextProduct() throws SQLException, IOException {
        if (index >= 10) {
            index = 0;
        }
        changeProduct(list.get(index++));
    }

    /*Method that goes to the previous product in a list*/
    public void prevProduct() throws SQLException, IOException {
        if (index <= 0) {
            index = 10;
        }
        changeProduct(list.get(--index));
    }

    /*Method that changes the product on product pages based on what key was clicked*/
    public void changeProduct(String click) throws SQLException, IOException {
        Connection con = connection();
        if (con == null) {
            System.out.println("Cannot connect to database");
            return;
        } else {
            try {
                Statement stmt = con.createStatement();
                ResultSet result = stmt.executeQuery("Select itemName, itemDesc, qty, price, image FROM inventory WHERE itemId = '" + click + "'");
                ResultSetMetaData rsmd = result.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                while (result.next()) {
                    for (int i = 1; i <= columnsNumber;) {
                        curProduct = result.getString(i);
                        curDesc = result.getString(i + 1);
                        curQty = result.getInt(i + 2);
                        curPrice = result.getDouble(i + 3);
                        curImage = result.getString(i + 4);
                        i += 5;
                    }
                }
                FacesContext.getCurrentInstance().getExternalContext().redirect("faces/product.xhtml");
            } finally {
                con.close();
            }
        }
    }

    /*main for debugging purposes*/
    public static void main(String[] args) throws SQLException {
        String version = FacesContext.class.getPackage().getImplementationVersion();
        System.out.println(version);
    }
    
    public  BufferedImage stringToImage(String imageString) throws IOException {
       BufferedImage image;
       image = ImageIO.read(getClass().getResource("resources/images/" + imageString));
    
       return image;
}
    
    

//    public BufferedImage reSize() throws IOException, AWTException {
//
//       
//        
//         BufferedImage scaledImage = Scalr.resize(bi, 200);
//         return scaledImage;
//    }
//
//    public static String imgToBase64String(final RenderedImage img, final String formatName) {
//        final ByteArrayOutputStream os = new ByteArrayOutputStream();
//        try {
//            ImageIO.write(img, formatName, Base64.getEncoder().wrap(os));
//            return os.toString(StandardCharsets.ISO_8859_1.name());
//        } catch (final IOException ioe) {
//            throw new UncheckedIOException(ioe);
//        }
//    }
//
//    public static BufferedImage base64StringToImg(final String base64String) {
//        try {
//            return ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode(base64String)));
//        } catch (final IOException ioe) {
//            throw new UncheckedIOException(ioe);
//        }
//    }

}
