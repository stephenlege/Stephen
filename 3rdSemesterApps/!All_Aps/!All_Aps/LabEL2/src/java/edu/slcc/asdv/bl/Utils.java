/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

import edu.slcc.asdv.beans.Purchases;

/**
 *
 * @author Greg
 */
public class Utils {
    public static boolean doBusinessLogic(Purchases bean){
        //bl not implemented
        return (Math.random() > .1);
    }
    public static boolean doDataAccessLogic(Purchases bean){
        //Db access not impl
        return (Math.random() > .1);
    }
}
