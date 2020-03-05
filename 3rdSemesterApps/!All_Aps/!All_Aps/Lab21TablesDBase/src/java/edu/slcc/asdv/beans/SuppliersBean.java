package edu.slcc.asdv.beans;

import edul.slcc.asdv.pojos.Suppliers;
import java.sql.SQLException;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.jsp.jstl.sql.Result;

@Named(value = "suppliers")
@RequestScoped
public class SuppliersBean {
    public Result getResultsuppliers() throws SQLException{
        return Suppliers.getAllSuppliers();
    }
}
