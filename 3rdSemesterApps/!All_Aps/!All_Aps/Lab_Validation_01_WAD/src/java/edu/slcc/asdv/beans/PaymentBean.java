/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Greg
 */
@Named(value = "paymentBean")
@SessionScoped
public class PaymentBean implements Serializable {

    private double amount;
    private String card = "";
    private Date date = new Date();

    public PaymentBean() {
   
    }
    
    

    public double getAmount() {
        return amount;
    }

    public String getCard() {
        return card;
    }

    public Date getDate() {
        return date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String navigate(){
        
        return "results";
    }
    
}
