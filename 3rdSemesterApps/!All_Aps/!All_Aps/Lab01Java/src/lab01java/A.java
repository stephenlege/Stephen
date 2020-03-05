/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01java;

import java.io.Serializable;

/**
 *
 * @author Greg
 */
public class A implements Serializable{
    String s;
    public A(){
        s = "This is the string var of class A";
    }

    public A(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "A{" + "s=" + s + '}';
    }
    
    
}
