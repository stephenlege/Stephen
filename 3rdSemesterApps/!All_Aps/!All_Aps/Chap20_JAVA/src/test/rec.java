/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Greg
 */
public class rec {
    static int c= 1;
    public static int f( int n )
  {
    if ( n==0 ) //line 1
        return 1; //line2
      System.out.println(" " + c++);
    return n * f( n -1); //line3
}

public static void main(String[] args)
 {
  f( 4 );
 }
}
