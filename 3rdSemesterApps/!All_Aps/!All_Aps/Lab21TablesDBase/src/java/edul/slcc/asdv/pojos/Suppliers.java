package edul.slcc.asdv.pojos;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

public class Suppliers {

    private static Connection connection() //throws InstantiationException, IllegalAccessException
    {

        String databaseName = "ap";
        String userName = "root";
        String password = "";
        String URL2 = "com.mysql.jdbc.Driver";
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
        String url = "jdbc:mysql://" + ip + ":3307/" + databaseName;
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
    
    public static Result getAllSuppliers() throws SQLException{
        Connection con = connection();
        if(con == null){
            System.out.println("Cannot connect to database");
            return null;
        }
        try{
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery("Select * FROM supplier");
            return ResultSupport.toResult(result);
        }
        finally{
            con.close();
        }
    }
}
