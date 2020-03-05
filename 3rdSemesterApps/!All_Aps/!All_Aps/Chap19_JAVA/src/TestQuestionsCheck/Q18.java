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
public class Q18 {
    
public static int f1( int n )
{
   if ( n == 1 || n == 2)
        return 1;

    int f = f1(n-1) - f1( n-2);
return f;
}

    public static void main(String[] args) {
        System.out.println(f1(5));
    }
}