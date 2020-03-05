/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import javax.el.ELContext;
import javax.el.LambdaExpression;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Greg
 */
@Named(value = "lambdaAction")
@RequestScoped
public class LambdaActtion {

    
    
    /**
     * creates a new instance of lambdaAction
     */
    public LambdaActtion() {
        
    }
    
    public Object lambda1(LambdaExpression lambdaExpression){
        //useful in case of a custon ELContext
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elContext = fc.getELContext();
        
        return lambdaExpression.invoke(elContext, 8, 3);
    }
}
