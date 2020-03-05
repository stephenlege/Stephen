/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LEGE
 */
public class UpdateData {
    
    /**
     *
     * @param con Checks if connecion was established
     * @param sql String sql statemtn
     * @throws SQLException
     * prints out wether or not the item was updated
     */
    public static void update(ConnectionEstablish con, String sql) throws SQLException{
        Statement stmt;
        try {
            stmt = con.getConnection().createStatement();
            stmt.execute(sql);
            con.closeConnection();
        } catch (SQLException ex) {
            System.out.println("Item not updated. " + ex.getMessage());
        }
        System.out.println("Item updated");
    }
}
