/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

import edu.slcc.asdv.utilities.DESUtil;


public class Encryption {
    
    /**
     *
     * @param pass Takes string password
     * @return Encrypted password
     */
    public static String encryptPass(String pass){
        return DESUtil.encrypt(pass);
    }
    
    /**
     *
     * @param pass String encrypted password
     * @return decrypted password
     */
    public static String decryptPass(String pass){
        return DESUtil.decrypt(pass);
    }
}
