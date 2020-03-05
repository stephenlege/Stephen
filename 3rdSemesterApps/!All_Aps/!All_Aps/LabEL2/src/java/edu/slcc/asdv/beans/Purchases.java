/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.bl.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Greg
 */
@Named(value = "purchases")
@RequestScoped
public class Purchases {

    private String [] cheapItems = {"Gum", "Yo-yo", "Pencil"};
    private List<String> mediumItems = new ArrayList<>();
    private Map<String, String> valuableItems = new HashMap<>();
    private boolean isEverythingOK = true;
    
    
    
    
    public Purchases() {
        mediumItems.add("iPod");
        mediumItems.add("GameBoy");
        mediumItems.add("Cell Phone");
        valuableItems.put("low", "Porche");
        valuableItems.put("medium", "Yacht");
        valuableItems.put("high", "Oracle, Training Course");
    }

    public String[] getCheapItems() {
        return cheapItems;
    }

    public List<String> getMediumItems() {
        return mediumItems;
    }

    public Map<String, String> getValuableItems() {
        return valuableItems;
    }

    public boolean isIsEverythingOK() {
        return isEverythingOK;
    }
    
    public String purchaseItems(){
        isEverythingOK = Utils.doBusinessLogic(this);
        isEverythingOK = Utils.doDataAccessLogic(this);
        if (isEverythingOK)return "purchase-success";
        else return "purchase-failure";
    }
    
}
