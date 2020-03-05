/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.pojos.Name;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Greg
 */
@Named(value = "tableData")
@SessionScoped
public class TableData implements Serializable {

    public Name[] getNames(){
        return names;
    }
    
    
    private static final Name[] names = new Name[]{
      new Name("William", "Dupont"), 
    new Name("Anna", "Keeney"),  
    new Name("Mariko", "Randor"),  
    new Name("John", "Wilson"),  
    };


}

