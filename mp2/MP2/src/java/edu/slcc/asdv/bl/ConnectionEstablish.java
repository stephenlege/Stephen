/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

import edu.slcc.asdv.utilities.Database;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *Gets Connection 
 * Closes a conection
 */


public class ConnectionEstablish {
    private Connection con;
    
    /**
     *
     * @return connection if there is a connection
     */
    public Connection getConnection() {
        con = (Connection) Database.connection();
        if (con == null) {
            System.out.println("Cannot connect to database");
            return null;
        } else {
            return con;
        }
    }
    
    /**
     *Closes Connection to Database
     * @throws SQLException
     */
    public void closeConnection() throws SQLException{
        con.close();
    }
}
