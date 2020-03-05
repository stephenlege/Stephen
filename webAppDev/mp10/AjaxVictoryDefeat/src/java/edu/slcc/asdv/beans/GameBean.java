/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author KIDSCOMPUTER
 */
@Named(value = "game")
@SessionScoped
public class GameBean implements Serializable {

    String page = "default";

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
    
    public String changePage(){
        double change = Math.random();
        switch(page){
            case "A": page = (change > 0.5)? "B" : "Defeat"; break;
            case "B": page = (change > 0.5)? "C" : "Defeat"; break;
            case "C": page = (change > 0.5)? "Victory" : "Defeat";break;
            case "Victory": page = "Victory"; break;
            case "Defeat": page = "Defeat"; break;
            default: page = "A"; break;
        }
        return page;
    }
    
}
