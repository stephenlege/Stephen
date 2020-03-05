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
public class Q15 {
 

 public static int f3(int x)
 {
 if (x == 1 || x == 2)
         return 1;

return f3((x + 2) / 2) + f3(x / 2);
 }

 public static void main(String[] args)
 {
 System.out.println( f3(7)  );
 }

}