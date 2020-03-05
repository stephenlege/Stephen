/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 *
 * 
 */
public interface Database {

    /**
     *
     * @param databaseName name
     * @param userName database user name
     * @param passord database password
     * @param driver driver that connects us to database
     * @return Connection the connection to databas or null if no connection
     */
    public Connection getConnection(String databaseName, String userName, String password, String driver);
    
    /**
     *
     * @param tableName the name of the table to return
     * @return a list with all rows in the table
     */
    public List<String> selectAllFromTable(String tableName);
    
    /**
     *
     * @param tableName the name of the table
     * @return true if the table exists in the database, false otherwise
     */
    boolean isTable(  String tableName);
    
  /**Selects the projected columns of a table where the AND condition 
   * of the Where clause is true
   * 
   * @param tableName table name
   * @param projectionFields fields if SELECT clause (projected columns)
   * @param whereFieldsNValues fields in where clause, key is the field name(
   * LHS ) and value of the field is (RHS).  For example snumber = 's1',
   * status > "10".
   * @param operators the operatros that apply to whereFieldsNValues.  They are positioned
   * between the LHS and the RHS of the whereFieldsNValues.  They are 
   * parameter.  The operators are alswyas half the size of the whereFieldsNValues.
   * That is, the first operator applies to the first two entries
   * of the map, the second operator to the 3rd and fourth entry of the map and so on.
   * @return the projected columns of a table where the AND condition of the 
   * Where clause.  NULL if an error(exception occurs)
   */
    public List<String> selectFieldsFromTableWhereFields(String tableName,
            List<String> projectionFields,
            Map<String, String> whereFieldsNValues,
            List<String> operators);
    
    
    /**
     * Select snumber, sname,city from supplier where snumber = 's1' AND status > 20;  
     * Our method is supposed to generate this and run it
     * can use regEX to seperate white spaces and comma
     */
    
    
    //-------------------------------------------------------------------------------------------------------
    
    /**
     *
     * @param c the connection to close
     */
    public void closeConnection(Connection c);
}
