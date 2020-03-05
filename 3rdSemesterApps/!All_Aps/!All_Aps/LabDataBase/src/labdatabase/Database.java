package labdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database 
{
    public static void main(String[] args)
    {
        Database db = new Database();
        Connection c = db.connection();
        db.listAllSuppliers();
        System.out.println(db.getResult());
        db.viewSuppliers("s1");
        System.out.println(db.getResult());
        db.viewSuppliersPartsInSP("s1", "p1");
        System.out.println(db.getResult());
        //db.insertSupplier("s7", "Brown", 20, "Lafayette");
        //System.out.println(db.getResult());
        db.updateSupplier("s7", "Black", 25, "Puerto Rico");
        System.out.println(db.getResult());
        
        db.deleteSupplier("s7");
        System.out.println(db.getResult());
        
        
        db.closeDatabaseConnection(c);
    }
    String result = "";

    public Database()
    {
        connection();
    }



    private Connection connection() //throws InstantiationException, IllegalAccessException
    {

        String databaseName = "SuppliersPartsClassOf2020";
        String userName = "root";
        String password = "";
        String URL2 = "com.mysql.jdbc.Driver";
        //String URL2 = "com.mysql.cj.jdbc.Driver";
        Connection con = null;
        try
          {// Load Sun's jdbc driver
            Class.forName(URL2).newInstance();
            System.out.println("JDBC Driver loaded!");
          }
        catch (Exception e) // driver not found
          {
            System.err.println("Unable to load database driver");
            System.err.println("Details : " + e);
            return null;
          }
        String ip = "localhost"; //internet connection
        String url = "jdbc:mysql://" + ip + ":3306/" + databaseName;
        try
          {
            con = DriverManager.getConnection(url, userName, password);
            con.setReadOnly(false);
          }
        catch (Exception e)
          {
            System.err.println(e.toString());
            return null;
          }
        System.out.println("connection successfull");
        return con;
    }


    public String getResult()
    {
        return  result;

    }

    

    public void closeDatabaseConnection( Connection con)
    {
        try
          {
            if (con != null)
              {
                con.close();
              }
          }
        catch (SQLException e)
          {
            result = e.toString();
            e.printStackTrace();
          }
    }
public void listAllSuppliers()
    {
        Connection con = connection();
        if (con == null)
          {
            result = "cannot connect to database" ;
            return ;
          }
        String table = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlStr = "SELECT  *  FROM supplier";
        try
          {
            //prepare statement
            ps = con.prepareStatement(sqlStr);
            //execute
            rs = ps.executeQuery();
              System.out.println("before entering while");
            while (rs.next())
              {
                  System.out.println("inside while");
                String sNumber = rs.getString(1) + " ";
                String sName = rs.getString(2) + " ";
                String status = rs.getInt(3) + " ";
                String city = rs.getString(4) + " ";
                table += sNumber + sName + status + city + "\n";
              }
          }
        catch (Exception ex)
          {
            ex.printStackTrace();
          }
        finally
          {
            try
              {
                closeDatabaseConnection(  con);
                // close the resources 
                if (ps != null)
                  {
                    ps.close();
                  }
              }
            catch (SQLException sqle){ sqle.printStackTrace(); }
          }
        result = table;
    }
  
    public void viewSuppliers(String snumber)
    {
        Connection con = connection();
        if (con == null)
          {
            result = "cannot connect to database" ;
            return ;
          }
        String ret = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlStr = "SELECT  *  FROM supplier WHERE snumber=?";
        try
          {
            //prepare statement
            ps = con.prepareStatement(sqlStr);
            ps.setString(1, snumber);
            //execute
            rs = ps.executeQuery();
            if (rs.next())
              {
                ret += rs.getString("snumber") + " ";
                ret += rs.getString("sname") + " ";
                ret += rs.getInt("status")+ " ";
                ret += rs.getString("city");
              }
            else{
                ret = snumber + " doesn't exist.";
            }
          }
        catch (Exception ex)
          {
            ex.printStackTrace();
          }
        finally
          {
            try
              {
                closeDatabaseConnection(  con);
                // close the resources 
                if (ps != null)
                  {
                    ps.close();
                  }
              }
            catch (SQLException sqle){ sqle.printStackTrace(); }
          }
        this.result = ret;
    }
  
    public void viewSuppliersPartsInSP(String snumber, String pnumber)
    {
        Connection con = connection();
        if (con == null)
          {
            result = "cannot connect to database" ;
            return ;
          }
        String ret = "";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sqlStr = "SELECT  *  FROM sp WHERE snumber=? AND pnumber=?";
        try
          {
            //prepare statement
            ps = con.prepareStatement(sqlStr);
            ps.setString(1, snumber);
            ps.setString(2, pnumber);
            //execute
            rs = ps.executeQuery();
            if (rs.next())
              {
                ret += rs.getString("snumber") + " ";
                ret += rs.getString("pnumber") + " ";
                ret += rs.getInt("qty");
              }
            else{
                ret = snumber + " an\\or " + pnumber + " doesn't exist.";
            }
          }
        catch (Exception ex)
          {
            ex.printStackTrace();
          }
        finally
          {
            try
              {
                closeDatabaseConnection(  con);
                // close the resources 
                if (ps != null)
                  {
                    ps.close();
                  }
              }
            catch (SQLException sqle){ sqle.printStackTrace(); }
          }
        this.result = ret;
    }
    
    public void insertSupplier(String snumber, String sname, int status, String city){
        Connection con = connection();
        if (con == null){
            result = "cannot connect to database";
            return;
        }
        PreparedStatement updateSupplier = null;
        try{
            updateSupplier = con.prepareStatement("INSERT INTO supplier (snumber, sname, status, city)" + "VALUES (?, ?, ?, ?)");
            updateSupplier.setString(1, snumber);
            updateSupplier.setString(2, sname);
            updateSupplier.setInt(3, status);
            updateSupplier.setString(4, city);
            
            int updateCount = updateSupplier.executeUpdate();
            result = "number of rows affected: " + updateCount;
        }
        catch(Exception ex){
            System.err.println(ex.toString());
            result = ex.toString();
        }
        finally{
            try{
                this.closeDatabaseConnection(con);
                if (updateSupplier != null)
                    updateSupplier.close();
            }
            catch(SQLException e){
                System.err.println(e.toString());
                result = e.toString();
            }
        }
    }
    
    public void updateSupplier(String snumber, String sname, int status, String city){
        Connection con = connection();
        if (con == null){
            result = "cannot connect to database";
            return;
        }
        PreparedStatement updateSupplier = null;
        try{
            updateSupplier = con.prepareStatement("UPDATE supplier SET snumber=?, sname=?, status=?, city=? WHERE snumber=?");
            updateSupplier.setString(1, snumber);
            updateSupplier.setString(2, sname);
            updateSupplier.setInt(3, status);
            updateSupplier.setString(4, city);
            updateSupplier.setString(5, snumber);
            int updateCount = updateSupplier.executeUpdate();
            result = "number of rows affected: " + updateCount;
        }
        catch(Exception ex){
            System.err.println(ex.toString());
        }
        finally{
            try{
                this.closeDatabaseConnection(con);
                if (updateSupplier != null)
                    updateSupplier.close();
            }
            catch(SQLException e){
                System.err.println(e.toString());
            }
        }
    }
    public void deleteSupplier(String snumber){
        Connection con = connection();
        if (con == null){
            result = "cannot connect to DB";
                    return;
        }
        PreparedStatement ps = null;
        int rowsAffected = -1;
        
        try{
            String query = "DELETE FROM supplier WHERE snumber=?";
            ps = con.prepareStatement(query);
            ps.setString(1,snumber);
            rowsAffected = ps.executeUpdate();
            result = "number of rows affected: " + rowsAffected;
        }
        
          catch(Exception ex){
            System.err.println(ex.toString());
        }
        finally{
            try{
                this.closeDatabaseConnection(con);
                if (ps != null)
                    ps.close();
            }
            catch(SQLException e){
                System.err.println(e.toString());
            }
        }
        
    }
    
}
