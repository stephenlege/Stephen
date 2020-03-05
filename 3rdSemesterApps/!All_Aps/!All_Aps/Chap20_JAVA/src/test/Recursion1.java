/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

public class Recursion1

{

static int i = 0, j = 0, k = 0;

public static void f4(int a[][], int b[][], int c[][])
{

    if (i < a.length)
        {
        if (j < b[0].length)
            {
            if (k < a[0].length)
                   {
                   c[i][j] += a[i][k] * b[k][j];
                   k++;
                   f4(a, b, c);
                   }
            k = 0;
            j++;
            f4(a, b, c);
           }
     j = 0;
     i++;
    f4(a, b, c);
    }
}

public static void main(String[] args)
{
  int[][]a = { {1,2}, {1,1} };


  int[][]b = { {1,1}, {1,1} };


   int[][]c = { {0,0}, {0,0} };
    f4( a, b, c);
    for ( int i=0; i < 2; ++i)
         for ( int j=0; j < 2; ++j)
              System.out.print(c[i][j] + " ");
 }

}