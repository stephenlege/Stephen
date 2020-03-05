/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
public class Recursion2
{

 public static int f4(int n, int k)
 {
 if (k == 0)
    return 1;
 else
    return n * f4(n, k-1);
 }


 public static void main(String[] args)
 {
 System.out.println(f4(2, 3) );
 }

}