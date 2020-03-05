/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1_java;

import java.util.Scanner;

/**
 *
 * @author Greg
 */
public class ComputeFibonacci {
    
    public static int count = 0;
    
    public static void main(String[] args) {
        //create scanner
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index for a Fibonacci number: ");
        int index = input.nextInt();
       
     
        
        //find and display the fibonacci number
        System.out.println("The Fibonacci number at index: " + index + " is " + fib(index));
        System.out.println("The number of method calls are: " + count);
        
        
        

        //for (int i = 0; i < 20; i++)
            //System.out.println(fib(i));
        
        //System.out.println(fib(10));
            
    }
    //the method ffor finding the fibonacci number
    public static long fib(long index){
        count++;
        
        if (index <= 1){
            //count++;
            return 1;}
        else {//reduction and recursive calls
            //count ++;
            return fib (index - 1) + fib(index - 2);
            
        }
    }
    //second solution
    public static long fib2(long n){
        long fibn;
        if (n <=2){
            count++;
            return 1;
            
        }
        fibn = fib(n-1) + fib(n-2);
        count++;
        return fibn;
    }
    /**using for loop (not recursion)
    public static int fib3(int n){
        
        if (n == 1 || n ==2)
            return 1;
        int fib1 = 1;
        int fib2 = 1;
        int fib = 2;
        for ( int i = 3; i <= n;i++ ){
           fib = fib1 + fib2;
           fib1 = fib2;
           fib2 = fib;
        }
        return fib;}
    
    */
        
}

