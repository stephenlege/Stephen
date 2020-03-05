/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestQuestionsCheck;

/**
 *
 * @author Greg
 */
public class Question13 {

public static int f1 ( int x )
 {
 if ( x == 1 )
    return 1;
 return f1( x-1) - 2 * x -1;
 }
 public static void main(String[] args)
  {
     System.out.println( f1( 3 ) );
   }
}
