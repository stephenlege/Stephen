/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Greg
 */
public class Queries implements Database {

    String databaseName = "supplierspartsclassof2020";
    String userName = "root";
    String password = "";
    String driver = "com.mysql.jdbc.Driver";

    @Override
    public Connection getConnection(String databaseName, String userName, String password, String driver) {

        //String URL2 = "com.mysql.cj.jdbc.Driver";
        Connection con = null;
        try {// Load Sun's jdbc driver
            Class.forName(driver).newInstance();
            System.out.println("JDBC Driver loaded!");
        } catch (Exception e) // driver not found
        {
            System.err.println("Unable to load database driver");
            System.err.println("Details : " + e);
            return null;
        }
        String ip = "localhost"; //internet connection
        String url = "jdbc:mysql://" + ip + ":3306/" + databaseName;
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

    @Override
    public List<String> selectAllFromTable(String tableName) {

        Connection con = getConnection(this.databaseName, this.userName, this.password, this.driver);
        if (con == null) {
            System.out.println("cannot connect to database");
            return null;
        }
        List<String> table = new ArrayList();

        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlStr = "SELECT  *  FROM " + tableName;
        try {
            //prepare statement
            ps = con.prepareStatement(sqlStr);
            //execute
            rs = ps.executeQuery();
            int numberOfCollumns = rs.getMetaData().getColumnCount();
            System.out.println("before entering while");

            while (rs.next()) {
                int parmIndex = 1;
                String oneRaw = "";
                while (parmIndex < numberOfCollumns) {
                    oneRaw += rs.getObject(parmIndex++).toString() + "  ";
                }
                table.add(oneRaw);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                closeConnection(con);
                // close the resources 
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return table;
    }

    public boolean isColumn(String tableName, List<String> projections) {
        Connection con = getConnection(this.databaseName, this.userName, this.password, this.driver);
        List<String> columns = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM " + tableName);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; ++i) {
                String columnName = metaData.getColumnName(i);
                columns.add(columnName);
            }
            int count = 0;
            for (int i = 0; i < projections.size(); ++i) {
                for (int j = 0; j < columns.size(); ++j) {
                    if (projections.get(i).compareToIgnoreCase(columns.get(j)) == 0) {
                        count++;
                    }
                }
            }
            if (count == projections.size()) {
                return true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                closeConnection(con);
                // close the resources 
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return false;
    }
    
    public boolean isColumn(String tableName, String [] projections) {
        Connection con = getConnection(this.databaseName, this.userName, this.password, this.driver);
        List<String> columns = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM " + tableName);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; ++i) {
                String columnName = metaData.getColumnName(i);
                columns.add(columnName);
            }
            int count = 0;
            for (int i = 0; i < projections.length; ++i) {
                for (int j = 0; j < columns.size(); ++j) {
                    if (projections[i].compareToIgnoreCase(columns.get(j)) == 0) {
                        count++;
                    }
                }
            }
            if (count == projections.length) {
                return true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                closeConnection(con);
                // close the resources 
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return false;
    }

    public boolean isFields(List<String> list) {
        Connection con = getConnection(this.databaseName, this.userName, this.password, this.driver);

        try {
            DatabaseMetaData metaData = con.getMetaData();
            String[] types = {"COLUMN"};

            ResultSet resultSet = metaData.getTables(con.getCatalog(), null, "%", types);

            while (resultSet.next()) {
                for (String word : list) {
                    int index = 0;
                    System.out.println(word);
                    if (word.compareToIgnoreCase(resultSet.getMetaData().getColumnName(index)) == 0) {
                        return true;
                    }
                    index++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                closeConnection(con);
                // close the resources 
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return false;
    }

    public boolean isOperand(List<String> list, Map<String, String> map) {
        List<String> keys = new ArrayList(map.keySet());
        if (list.size() != keys.size()) {
            return false;
        }
        for (String word : list) {
            if (!word.matches("[= > < <= >= != <>]")) {
                return false;
            }
        }

        return true;
    }

    public boolean isWhere(List<String> list) {
        Connection con = getConnection(this.databaseName, this.userName, this.password, this.driver);
//        String[] array = new String[list.size()];
//
//        for (int i = 0; i < list.size(); i++) {
//            array[i] = list.get(i);
//        }
        try {
            DatabaseMetaData metaData = con.getMetaData();
            String[] types = {"COLUMN"};
            ResultSet resultSet = metaData.getTables(con.getCatalog(), null, "%", types);
            
            int numberOfColumns = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                for (int i = 0; i < list.size(); i++) {
                    for (int j = 0; j < numberOfColumns; j++) {
                        if (list.get(i).compareToIgnoreCase(resultSet.getMetaData().getColumnName(j)) == 0) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        } finally {
            try {
                closeConnection(con);
                // close the resources 
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return false;
    }

    public boolean isWhereColumn(Map<String, String> map) {
        Connection con = getConnection(this.databaseName, this.userName, this.password, this.driver);

        try {
            DatabaseMetaData metaData = con.getMetaData();
            String[] types = {"COLUMN"};
            ResultSet resultSet = metaData.getTables(con.getCatalog(), null, "%", types);
            List<String> keys = new ArrayList(map.keySet());

            int index = 0;
            while (resultSet.next()) {
                if (keys.get(index).compareToIgnoreCase(resultSet.getString("COLUMN_NAME")) == 0) {

                    return true;
                }
                index++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                closeConnection(con);
                // close the resources 
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean isTable(String tableName) {
        Connection con = getConnection(this.databaseName, this.userName, this.password, this.driver);

        try {
            DatabaseMetaData metaData = con.getMetaData();
            String[] types = {"TABLE"};
            ResultSet resultSet = metaData.getTables(con.getCatalog(), null, "%", types);

            while (resultSet.next()) {
                if (tableName.compareToIgnoreCase(resultSet.getString("TABLE_NAME")) == 0) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                closeConnection(con);
                // close the resources 
                if (con != null) {
                    con.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return false;
    }

    public String processProjectionFields(List<String> list) {
        String s = "";

        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                s += list.get(i) + ", ";
            } else {
                s += list.get(i);
            }
        }
        //System.out.println(s);
        return s;
    }

    public String processWhereAndOperators(Map<String, String> map, List<String> list) {
        String s = "";
        int getCount = map.size();
        //System.out.println(getCount);
        List<String> keys = new ArrayList(map.keySet());
        List<String> values = new ArrayList(map.values());

        for (int i = 0; i < getCount; i++) {

            if (i == 0) {
                s += keys.get(i) + " " + list.get(i) + " " + "'" + values.get(i) + "'";
            } else {
                s += " AND " + keys.get(i) + " " + list.get(i) + " " + "'" + values.get(i) + "'" + " ";
            }
            if (i == getCount - 1) {
                break;
            }
        }
        //System.out.println(s);
        return s;
    }

    @Override
    public void closeConnection(Connection c) {

        try {
            if (c != null) {
                c.close();
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
//----------------------------------------------------------------------------------------------------------------------------------HW

    @Override
    public List<String> selectFieldsFromTableWhereFields(String tableName,
            List<String> projectionFields, Map<String, String> whereFieldsNValues,
            List<String> operators) {
        Connection con = getConnection(this.databaseName, this.userName, this.password, this.driver);
        List<String> table = new ArrayList();
        List<String> keys = new ArrayList(whereFieldsNValues.keySet());

        if (con == null) {
            System.out.println("cannot connect to database");
            return null;
        }

        if (!isTable(tableName)) {
            System.out.println("This table does not exist.");
            return null;
        }
        if (!isColumn(tableName, projectionFields)) {
            table.add("One or more of the columns are wrong.");
            return table;
        }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////???????????????????
        if (isWhere(keys)) {
            table.add("No columns match this table in your WHERE clause");
            return table;
        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (!isOperand(operators, whereFieldsNValues)) {
            table.add("Operands are not Correct");
            return table;
        }

        PreparedStatement ps = null;
        ResultSet rs = null;

        String sqlStr = "";

        sqlStr = "Select " + processProjectionFields(projectionFields) + " FROM " + tableName + " WHERE ";
        System.out.println(sqlStr);

        if (whereFieldsNValues.isEmpty()) {
            sqlStr += "1";
        } else {
            sqlStr += processWhereAndOperators(whereFieldsNValues, operators);
        }

        System.out.println(sqlStr);

        try {
            //prepare statement
            ps = con.prepareStatement(sqlStr);
            //execute
            rs = ps.executeQuery();
            int numberOfCollumns = rs.getMetaData().getColumnCount();
            System.out.println("before entering while");

            while (rs.next()) {
                int parmIndex = 1;
                String oneRaw = "";
                while (parmIndex <= numberOfCollumns) {
                    oneRaw += rs.getObject(parmIndex++).toString() + "  ";
                }
                table.add(oneRaw);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                closeConnection(con);
                // close the resources 
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
        return table;
    }

}
