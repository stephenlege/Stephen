/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author KIDSCOMPUTER
 */
@Named(value = "count")
@SessionScoped
public class CountBean implements Serializable{

    int count = -1;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    public int addClick(){
        return ++count;
    }
    
    public String result(){
        count = ++count;
        return "You clicked " + count + " times";
    }
}
