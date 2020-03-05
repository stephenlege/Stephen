/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.utilities.DESUtil;
import edu.slcc.asdv.utilities.Database;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    // <editor-fold defaultstate="collapsed" desc="Variables">
    private static String[] userNames = new String[10];

    private static Map<String, String> userPass = new HashMap<>();

    private static String userName1;

    private static String password1;

    private String error;
    private String emailError;
    private String item;
    private String image;
    private String desc;
    private int qty;

    private String userName2;
    private String password2;

    byte[] key = new byte[]{
        21, 1, -110, 82, -32, -85, -128, -65
    };

    private String loginBarStyles = "visibility: visible;";
    private String loginInfoStyles = "visibility: collapse;";

    // </editor-fold>
    
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getEmailError() {
        return emailError;
    }

    public String getUserName2() {
        return userName2;
    }

    public void setUserName2(String userName2) {
        this.userName2 = userName2;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getLoginBarStyles() {
        return loginBarStyles;
    }

    public void setLoginBarStyles(String loginBarStyles) {
        this.loginBarStyles = loginBarStyles;
    }

    public String getLoginInfoStyles() {
        return loginInfoStyles;
    }

    public void setLoginInfoStyles(String loginInfoStyles) {
        this.loginInfoStyles = loginInfoStyles;
    }

    public String[] getUserNames() {
        return userNames;
    }

    public void setUserNames(String[] userNames) {
        LoginBean.userNames = userNames;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        LoginBean.password1 = password1;
    }

    public String getUserName1() {
        return userName1;
    }

    public void setUserName1(String userName1) {
        LoginBean.userName1 = userName1;
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
    
    /*Method that pulls all the users from the database and stores them in a MAP*/
    public static void getAllUsers() throws SQLException {
        Connection con = connection();
        if (con == null) {
            System.out.println("Cannot connect to database");
            return;
        } else {
            try {
                Statement stmt = con.createStatement(); ResultSet result = stmt.executeQuery("Select * FROM users");
                ResultSetMetaData rsmd = result.getMetaData(); int columnsNumber = rsmd.getColumnCount();
                while (result.next()) {
                    for (int i = 1; i <= columnsNumber;) {
                        String columnValue = result.getString(i); String columnValue2 = result.getString(i + 1);
                        userPass.put(columnValue, columnValue2); i += 3;
                    }}
                userPass.forEach((K, V) -> {
                    System.out.println(K + " " + V);
                });
            } finally {
                con.close();
            }}}

    /*Method that checks wether a user is already stored in database or not*/
    public boolean validateUser() throws IOException {
        for (int i = 0; i < userPass.size(); ++i) {
            if (userPass.containsKey(userName1)) {
                String savedPass = DESUtil.decrypt(userPass.get(userName1));
                if (password1.equals(savedPass)) {
                    error = "";
                    return true;
                } else {
                    reload();
                    error = "Incorrect Password";
                }}}
        return false;
    }

    /*Directs users to register if they are not validated*/
    public String login() throws IOException {
        try {
            getAllUsers();
        } catch (SQLException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (validateUser()) {
            loginBarStyles = "visibility: collapse;";
            loginInfoStyles = "visibility: visible;";
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } else {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
        }
        return null;
    }

    /*Method that adds user to the database*/
    public void register() throws SQLException, IOException {
        boolean registered;
        List<String> userNames2 = new ArrayList<>(userPass.keySet());
        for (int i = 0; i < userNames2.size(); ++i) {
            if (userNames2.get(i).equalsIgnoreCase(userName2)) {
                emailError = "User already exists.";
                return;}}
        emailError = "";
        String encryptedPassword = DESUtil.encrypt(password2, key);
        Statement stmt = Database.getConnection().createStatement();
        registered = stmt.execute("INSERT INTO `users` (`username`, `password`) VALUES ('" + userName2 + "', '" + encryptedPassword + "')");
        registered = true;
        if (registered) {
            error = "Registered, please log in";
            loadPage("index.xhtml");}}
    
    /*Quick method for loading page*/
    public void loadPage(String page) throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect(page);
    }

    /*Method for re-loading a specific page*/
    public static void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }
}
