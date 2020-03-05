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


public class AccountSync6 {
  private static Account account = new Account();

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.execute(new DepositTask());
    executor.execute(new WithdrawTask());
    executor.shutdown();

    System.out.println("Deopist Task\t\tWithdraw Task\t\tBalance");
  }

  // A task for adding an amount to the account
  public static class DepositTask implements Runnable {
    public void run() {
      try { 
        while (true) {
          account.deposit((int)(Math.random() * 11));
          Thread.sleep(1000);
        }
      }
      catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }

  // A task for subtracting an amount from the account
  public static class WithdrawTask implements Runnable {
    public void run() {
      while (true) {
        account.withdraw((int)(Math.random() * 11));
      }
    }
  }

  
  public static class Account {
    private int balance = 0;

    public int getBalance() {
      return balance;
    }

    public synchronized void deposit(int amount) {
      balance += amount;
      System.out.println("Deposit " + amount +
        "\t\t\t\t\t" + getBalance());
      notifyAll();
    }

    public synchronized void withdraw(int amount) {
      try {
        while (balance < amount)
          wait();
      }
      catch (InterruptedException ex) {
        ex.printStackTrace();
      }

      balance -= amount;
      System.out.println("\t\t\tWithdraw " + amount +
        "\t\t" + getBalance());
    }
  }
}
