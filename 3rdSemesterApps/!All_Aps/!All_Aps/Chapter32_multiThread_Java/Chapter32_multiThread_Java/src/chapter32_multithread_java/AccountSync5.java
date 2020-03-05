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

public class AccountSync5 {

    private Account account = new Account();
    //private ExecutorService executorW;


    public static void main(String[] args) {
        //create a thread pool with two threads
        AccountSync5 a5 = new AccountSync5();
        Thread t1 = new Thread(a5.new DepositTask());
        Thread t2 = new Thread(a5.new WithdrawTask());
        
        t1.start();
        t2.start();
      
        
        

        System.out.println("Thread 1\t\tThread 2\t\tBalance");
    }

    private static final Object MUTEX = new Object();
    //create Withdraw Task
    public class WithdrawTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                account.withdraw((int) (Math.random() * 11));
            }
        }

    }

    //create Deposit Task
    public class DepositTask implements Runnable {

        @Override
        public void run() {
            try {
                while (true) {
                    account.deposit((int) (Math.random() * 11));
                    Thread.sleep(100);
                }

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }

    // An inner class for account
    public class Account {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        private Lock lock = new ReentrantLock(); // Create a lock
        private Condition newDepositCondition = lock.newCondition(); //Create condition
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

//        public Account() {
//             executor.execute(new WithdrawTask());
//        executor.execute(new DepositTask());
//        }
        

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

            executor.shutdown();
        }
        
    }
}
