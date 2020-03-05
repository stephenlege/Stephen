/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpout;

/**
 *
 * @author Greg
 */
public class HelpOut {

   
    public static void main(String[] args) {
        int x = 8; int y = 15; double d = 2;
        
        //1
         x+=2;
        
        //2
        y+=5;
        
        //3
        d++;
        
        //4
        double z1 = (double)x/ y * d++;
        System.out.println ( z1 );
        //5
        double z2 = (double)x / y * ++d;
        System.out.println( z2 );
        
        
        //6
        double z3 = (double)x / y * --d;
        System.out.println(z3);
        //
        
       
        System.out.println("x=" + x + " y=" + y + " d=" + d + " z1= " + z1+ 
                " z2= " + z2 + " z3= " + z3);
        
        
    }
}

