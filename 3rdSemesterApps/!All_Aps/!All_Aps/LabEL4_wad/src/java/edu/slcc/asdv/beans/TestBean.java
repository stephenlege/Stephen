/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Greg
 */
@Named("testBean")
@RequestScoped

public class TestBean {

    @ManagedProperty(value = "#{param.key1}")   //needs to assign value of joe to @ManagedProperty
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void method1(String s) {
        System.out.println(s);
        
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();
        System.out.println(params.get("key1"));
    }

}
