package edu.slcc.asdv.beans;

import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.RequestScoped;

@Named(value = "jackjack")
@RequestScoped
public class jackjack implements Serializable {

    private Date date = new Date();
    
    public Date getDate() {
        return new Date();
    }

}
