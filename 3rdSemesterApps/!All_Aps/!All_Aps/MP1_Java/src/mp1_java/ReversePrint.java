/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1_java;

/**
 *
 * @author Greg
 */
public class ReversePrint {
    
   public static String sR = "";
    
    public static void main(String[] args) {
        //printReversedString("Hello World!");
        System.out.println(printReversedString("Hello"));
    }
    
    
    public static String printReversedString(String s){
        //String sR = "";
        
        if (s.length() == 0)
            return sR;
        if (s.length() >= 1){
            printReversedString(s.substring(1,s.length()));
            sR += s.charAt(0);
        }
        return sR;
    }
    
    /**String s1 = ""
     * s1 = s;
     * s1 += printReversedString(s.substring(0,s.length()-1));
     * return s1
     */
     
    
    
    
    
    
}
