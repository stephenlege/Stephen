
package edu.slcc.asdv.pojos;

public class User {

    /*Variables for the User*/
    private String email;
    private String password;
    private String type;

    /*Default Constructor*/
    public User() {
    }
    
    /*Overloaded constructor that takes arguments*/
    public User(String email, String password, String type) {
        this.email = email;
        this.password = password;
        this.type = type;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
    /*returns type*/
    public String getType() {
        return type;
    }

    /*sets type*/
    public void setType(String type) {
        this.type = type;
    }

    /*returns password*/
    public String getPassword() {
        return password;
    }

    /*sets password*/
    public void setPassword(String password) {
        this.password = password;
    }

    /*return email*/
    public String getEmail() {
        return email;
    }

    /*sets email*/
    public void setEmail(String email) {
        this.email = email;
    }
    //</editor-fold>

}
