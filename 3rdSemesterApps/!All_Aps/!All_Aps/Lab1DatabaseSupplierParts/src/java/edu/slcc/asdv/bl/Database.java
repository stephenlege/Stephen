/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

import java.util.List;
import java.sql.Connection;
import java.util.Map;

/**
 *
 * @author KIDSCOMPUTER
 */
public interface Database {

    /**
     * Returns a Connection to the database or null if no connection is
     * established.
     *
     * @param databaseName
     * @param username
     * @param password
     * @param driver
     * @return
     */
    public Connection getConnection(String databaseName, String username, String password, String driver);

    /**Selects the projected columns of a table where the AND condition of the WHERE clause is true.
     *
     * @param tableName table name
     * @param projectionFields fields if SELECT clause (projected columns)
     * @param whereFieldsNValues fields in where clause, key is the field name(LHS) and value of the field(RHS). For ex.snumber = 's1', status > "10"
     * @param operators the operators that apply to whereFieldsNValues. They are positioned between the LHS and the RHS of the whereFieldsNValues parameter.
     * The operators are always half the size of the WhereFieldsNValues. That is, the first operator applies to the first two entries of the map, the second
     * operator to the third and fourth entry of the map and so on.
     * @return the projected columns of a table, after the WHERE applies by ANDing all entries of the map (whereFieldsNValues). If an SQL exception is thrown
     * return NULL if an error occurs.
     */
    public List<String> selectAllFromTableWhereFields(String tableName, List<String> projectionFields, Map<String, String> whereFieldsNValues, List<String> operators);

    /**
     * Returns the list of all rows of the table "tableName".
     *
     * @param tableName
     * @return
     */
    public List<String> selectAllFromTable(String tableName);

    /**
     * Returns true if the table exists in the database, false otherwise.
     *
     * @param tableName
     * @return
     */
    boolean isTable(String tableName);

    /**
     * Closes connection to the current database.
     *
     * @param c
     */
    public void closeConnection(Connection c);

}
