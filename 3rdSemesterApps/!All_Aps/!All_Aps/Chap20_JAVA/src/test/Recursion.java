/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

public class Recursion
{
    static int count = 0;

    public  static int fib(int n)
    {
        count++;
        if (n == 0)
            {
            return 0;
            }
        else if (n == 1)
            {
            return 1;
            }
        else // Reduction and recursive calls
            {
            return fib(n - 1) + fib(n - 2);
            }

    }
    public static void main(String[] args)
    {
        fib( 3 ) ;
        System.out.println( count);
    }
}