package edu.slcc.asdv.bl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Queries implements Database {

    String databaseName = "SuppliersPartsClassOf2020";
    String userName = "root";
    String password = "";
    String driver = "com.mysql.jdbc.Driver";

    @Override
    public Connection getConnection(String databaseName, String username, String password, String driver) {
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
            con = DriverManager.getConnection(url, username, password);
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
            System.out.println("no connection....cannot connect to database");
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
            int numberOfColumns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                int paramIndex = 1;
                String oneRaw = "";
                while (paramIndex < numberOfColumns) {
                    oneRaw += rs.getObject(paramIndex++).toString() + " ";
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

    @Override
    public List<String> selectAllFromTableWhereFields(String tableName, List<String> projectionFields, Map<String, String> whereFieldsNValues, List<String> operators) {
        Connection con = getConnection(this.databaseName, this.userName, this.password, this.driver);
        List<String> table = new ArrayList();
        if (isTable(tableName) == false) {
            System.out.println("That table does not exist in this database.");
            return null;
        }
        if (isColumn(tableName, projectionFields) == false) {
            table.add("One or more of the columns does not exist.");
            return table;
        }
        String sqlStr = "SELECT ";
        for (int i = 0; i < projectionFields.size(); ++i) {
            if (i != projectionFields.size() - 1) {
                sqlStr += projectionFields.get(i) + ", ";
            } else {
                sqlStr += projectionFields.get(i) + " ";
            }
        }
        sqlStr += "FROM " + tableName + " WHERE ";
        List<String> where = new ArrayList<>();
        whereFieldsNValues.forEach((k, v) -> {
            where.add(k);
            where.add(v);
            System.out.println(Arrays.asList(where));
        });
        for (int i = 0, j = 0; j < operators.size(); i += 2, ++j) {
            if (j < operators.size() - 1) {
                sqlStr += where.get(i) + " " + operators.get(j) + " '" + where.get(i + 1) + "' AND ";
            } else {
                sqlStr += where.get(i) + " " + operators.get(j) + " '" + where.get(i + 1) + "'";
            }
        }
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //prepare statement
            ps = con.prepareStatement(sqlStr);
            //execute
            rs = ps.executeQuery();
            int numberOfColumns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                int paramIndex = 1;
                String oneRaw = "";
                while (paramIndex <= numberOfColumns) {
                    oneRaw += rs.getObject(paramIndex++).toString() + " ";
                    System.out.println(oneRaw);
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
