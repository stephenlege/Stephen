/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter32_multithread_java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountSync2 {

    private static Account account = new Account();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        // Create and launch 100 threads
        for (int i = 0; i < 100; i++) {
            executor.execute(new AddAPennyTask());
        }

        executor.shutdown();

        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }

        System.out.println("What is balance? " + account.getBalance());
    }

    // A thread for adding a penny to the account
    private static class AddAPennyTask implements Runnable {

        public void run() {
            //synchronized (this){
            account.deposit(10);
        }
    }

    // An inner class for account
    private static class Account {

        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            synchronized (this) {
                int newBalance = balance + amount;

                // This delay is deliberately added to magnify the
                // data-corruption problem and make it easy to see.
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                }

                balance = newBalance;
            }
        }
    }
}
