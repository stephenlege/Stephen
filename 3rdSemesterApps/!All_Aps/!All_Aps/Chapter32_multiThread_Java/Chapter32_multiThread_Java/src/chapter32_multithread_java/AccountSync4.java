/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter32_multithread_java;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountSync4 {

    private static Account account = new Account();

    public static void main(String[] args) {
        //create a thread pool with two threads
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new WithdrawTask());
        executor.execute(new DepositTask());
        
        executor.shutdown();
        
        System.out.println("Thread 1\t\tThread 2\t\tBalance");
    }
    
    //create Withdraw Task
    public static class WithdrawTask implements Runnable{

        @Override
        public void run() {
            while(true){
                account.withdraw((int) (Math.random() * 11));
            }
        }
        
    }

    //create Deposit Task
    public static class DepositTask implements Runnable {

        @Override
        public void run() {
            try{
                while(true){
                    account.deposit((int)(Math.random() * 11));
                    Thread.sleep(100);
                }
                    
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }

        }
    }

    // An inner class for account
    public static class Account {

        private static Lock lock = new ReentrantLock(); // Create a lock
        private static Condition newDepositCondition = lock.newCondition(); //Create condition
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) {
            lock.lock(); // Acquire the lock

            try {

                while (balance < amount) {
                    System.out.println("\t\t\tWait for a depo" + "\t\t" + getBalance());
                    newDepositCondition.await();
                }

                balance -= amount;
                System.out.println("\t\t\tWithdraw" + amount + "\t\t" + getBalance());

                // This delay is deliberately added to magnify the
                // data-corruption problem and make it easy to see.
                //Thread.sleep(10);
                //balance = newBalance;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock(); // Release the lock
            }
        }

        public void deposit(int amount) {
            lock.lock(); // Acquire the lock

            try {
                balance += amount;
                System.out.println("\t\t\tDeposit" + amount + "\t\t\t\t\t" + getBalance());

                ///signal thread waiting on the condition
                newDepositCondition.signalAll();

            } finally {
                lock.unlock(); // Release the lock
            }

        }
    }
}
