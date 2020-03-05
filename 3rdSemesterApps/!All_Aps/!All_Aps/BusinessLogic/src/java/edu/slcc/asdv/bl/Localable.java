/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

import java.util.Locale;

/**
 *
 * @author Greg
 */
public interface Localable {
    public Locale locale();

    @Override
    public String toString();
    
    
    public String changeLocale(String localeAcronym);
}
