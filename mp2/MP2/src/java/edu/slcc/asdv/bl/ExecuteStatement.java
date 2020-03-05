/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

import java.sql.SQLException;
import java.sql.Statement;


public class ExecuteStatement {
    
    /**
     *
     * @param con established Connection
     * @param sql String stmt
     * @throws SQLException 
     */
    public static void add(ConnectionEstablish con, String sql) throws SQLException{
        try{
            Statement stmt;
            stmt = con.getConnection().createStatement();
            stmt.execute(sql);
        } catch(SQLException ex){
            System.out.println("Adding failed." + ex.getMessage());
        }
        con.closeConnection();
        System.out.println("Adding success!");
    }
}
