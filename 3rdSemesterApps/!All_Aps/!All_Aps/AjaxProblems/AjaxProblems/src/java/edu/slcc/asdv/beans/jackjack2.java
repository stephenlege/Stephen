package edu.slcc.asdv.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

@Named(value = "jackjack2")
@SessionScoped
public class jackjack2 implements Serializable{

  private int count;

    public int getCount() {
        return (count++);
    }
    
}
