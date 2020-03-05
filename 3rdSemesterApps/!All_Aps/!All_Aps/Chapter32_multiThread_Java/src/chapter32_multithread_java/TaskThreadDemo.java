/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter32_multithread_java;

public class TaskThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        // Create tasks
        Runnable printA = new PrintChar('a', 100);
        Runnable printB = new PrintChar('b', 100);
        Runnable print100 = new PrintNum(100);

        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);
        System.out.println("-------------------------------------------------");
        
        
        
        
        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
        
        
    }
}

// The task for printing a specified character in specified times
class PrintChar implements Runnable {

    private char charToPrint; // The character to print
    private int times; // The times to repeat

    /**
     * Construct a task with specified character and number of times to print
     * the character
     */
    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }
    
    
  
    
    @Override
    /**
     * Override the run() method to tell the system what the task to perform
     */
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(charToPrint);
              if(i< 50)
            try{
        Thread.sleep(1000);}
        catch(InterruptedException ex){
            
        }
        }
        System.out.println("");
        
    }
}

// The task class for printing number from 1 to n for a given n
class PrintNum implements Runnable {

    private int lastNum;

    /**
     * Construct a task for printing 1, 2, ... i
     */
    public PrintNum(int n) throws InterruptedException {
        lastNum = n;
        //Thread.yield();
        
      
    }
    
  
    public void run1() {
        for (int i = 1; i <= lastNum; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }
    
    @Override
    /**
     * Tell the thread how to run
     */
      public void run(){
        Thread thread4 = new Thread(new PrintChar('c',200));
        thread4.start();
        try{
            for(int i =1;i <=lastNum;i++){
            System.out.print(" " + i);
            if(i==50)
                thread4.join();
        }}
        catch(InterruptedException ex){}
    }
    
    
}
