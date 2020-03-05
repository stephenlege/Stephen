/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigohlab06_java;

public class GCD
{

    /**
     * O(n) time
     *
     * @param m
     * @param n
     * @return
     */
    public static long gcd1(long m, long n)
    {
        long gcd = 1;

        if (m == n)
          {
            return m;
          }

        for (int k = 1; k <= m / 2 && k <= n / 2; k++)
          {
            if (m % k == 0 && n % k == 0)
              {
                gcd = k;
              }
          }

        return gcd;
    }

    /**
     * O(n) time
     *
     * @param m
     * @param n
     * @return
     */
    public static long gcd2(int m, int n)
    {
        int gcd = 1;
        if (m % n == 0)
          {
            return n;
          }
        for (int k = n / 2; k >= 1; k--)
          {
            if (m % k == 0 && n % k == 0)
              {
                gcd = k;
                break;
              }
        }
        return gcd;
    }

    /**
     * O(logn) time
     *
     * @param m
     * @param n
     * @return
     */
    public static long gcd3(int m, int n)
    {
        if (m == 0)
          {
            return n;
          }
        if (n == 0)
          {
            return m;
          }
        if (m > n)
          {
            return gcd3(m % n, n);
          }
        else
          {
            return gcd3(m, n % m);
          }
    }

    /**
     * O(logn) time
     *
     * @param m
     * @param n
     * @return
     */
    public static long gcd4(int m, int n)
    {

        while (m != 0 && n != 0)
          {

            if (m > n)
              {
                m = m % n;
              }
            else
              {
                n = n % m;
              }
          }
        return m == 0 ? n : m;
    }

    public static void main(String[] args)
    {

        // Find the first 1000 Fibonacci numbers
        final int INDEX = 10000;
        int[] numbers = new int[INDEX];
        numbers[0] = 0;
        numbers[1] = 1;
        final int LOW = 40;
        final int HIGH = 45;

        for (int i = 2; i < INDEX; i++)
          {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
          }
        System.out.println("1st fib " + numbers[0]);
        System.out.println("2nd fib " + numbers[1]);
        System.out.println("3rd fib " + numbers[2]);
        System.out.println("4th fib " + numbers[3]);
        System.out.println("5th fib " + numbers[4]);
        System.out.println("6th fib " + numbers[5]);
        System.out.println("7th fib " + numbers[6]);
        System.out.println("45th " + numbers[44]);
        System.out.println("46th " + numbers[45]);
        System.out.println("47th " + numbers[46]);
        System.out.println("48th OVERFLOW*** " + numbers[47]);

        //System.exit( 888);
        for (int i = LOW; i <= HIGH; i++)
          {
            System.out.print("   \t\t" + (i + 1));
          }
        System.out.println("\n-----------------------------------------------------------------------------------------------");
        System.out.println("GCD1  O(n) time");

        long[] executionTime = new long[6];

        for (int i = LOW; i <= HIGH; i++)
          {
            long startTime = System.currentTimeMillis();
            System.out.print("fib numbers: " + numbers[i] + ", " + numbers[i + 1]);
            long gcd = gcd1(numbers[i], numbers[i + 1]);
            System.out.println(" GCD: " + gcd);
            executionTime[i - LOW] = System.currentTimeMillis() - startTime;
          }

        for (int i = 0; i <= 5; i++)
          {
            System.out.print("\t time:" + executionTime[i]);
          }

        System.out.println("\n\nGCD2 O(n) time");

        for (int i = LOW; i <= HIGH; i++)
          {
            long startTime = System.currentTimeMillis();
            System.out.print("fib numbers: " + numbers[i] + ", " + numbers[i + 1]);
            long gcd = gcd2(numbers[i], numbers[i + 1]);
            System.out.println(" GCD: " + gcd);
            executionTime[i - LOW] = System.currentTimeMillis() - startTime;
          }

        for (int i = 0; i <= 5; i++)
          {
            System.out.print("\t time:" + executionTime[i]);
          }
        System.out.println("");

        System.out.println("\n\n\nGCD3 O(logN) time recursive");

        for (int i = LOW; i <= HIGH; i++)
          {
            long startTime = System.nanoTime();
            System.out.print("fib numbers: " + numbers[i] + ", " + numbers[i + 1]);
            long gcd = gcd3(numbers[i], numbers[i + 1]);
            System.out.println(" GCD: " + gcd);
            executionTime[i - LOW] = System.nanoTime() - startTime;
          }

        for (int i = 0; i <= 5; i++)
          {
            System.out.print("\t time:" + executionTime[i]);
          }

        System.out.println("\n\n\nGCD4 O(logN) time iterative");

        for (int i = LOW; i <= HIGH; i++)
          {
            long startTime = System.nanoTime();
            System.out.print("fib numbers: " + numbers[i] + ", " + numbers[i + 1]);
            long gcd = gcd4(numbers[i], numbers[i + 1]);
            System.out.println(" GCD: " + gcd);
            executionTime[i - LOW] = System.nanoTime() - startTime;
          }

        for (int i = 0; i <= 5; i++)
          {
            System.out.print("\t time:" + executionTime[i]);
          }
        System.out.println("");

        
        
        //System.out.println(gcd2(64,48));
    }

}