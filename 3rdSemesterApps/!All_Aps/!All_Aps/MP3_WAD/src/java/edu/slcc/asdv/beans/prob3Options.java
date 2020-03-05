/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;



/**
 *
 * @author Greg
 */
@Named(value = "prob3")
@ApplicationScoped
public class prob3Options {
    
   private Map<String, String> nameMap = new LinkedHashMap<>();

  private String [] names = {"Cay", "David", "Marty"};
  private String [] names2 = {"Cay Horstmann", "David Geary", "Marty Hall"};

    public prob3Options() {
        for (int i =0; i < names.length;i++){
            String first = names[i];
            String full = names2[i];
            nameMap.put(first, full);
        }
        
    }

    public void setNames2(String[] names2) {
        this.names2 = names2;
    }

    public String[] getNames2() {
        return names2;
    }

    

    public String[] getNames() {
        return names;
    }

    public Map<String, String> getNameMap() {
        return nameMap;
    }

    public void setNameMap(Map<String, String> nameMap) {
        this.nameMap = nameMap;
    }

  

    public void setNames(String[] names) {
        this.names = names;
    }

   
    
    
}
