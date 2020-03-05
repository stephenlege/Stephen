/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

import java.sql.SQLException;
import java.sql.Statement;


public class DeleteData {
    
    /**
     *
     * @param con Takes a completed connection
     * @param sql Takes a String SQL statement
     * @return Message if update Happened(deletion)
     * @throws SQLException
     */
    public static String delete(ConnectionEstablish con, String sql) throws SQLException{
        Statement stmt;
        try {
            stmt = con.getConnection().createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
           return "Item not updated. " + ex.getMessage();
        }
        con.closeConnection();
        return "Item updated.";
    }
}
