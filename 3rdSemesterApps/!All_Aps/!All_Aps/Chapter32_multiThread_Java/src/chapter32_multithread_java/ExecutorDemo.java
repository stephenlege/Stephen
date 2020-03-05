/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter32_multithread_java;

import java.util.concurrent.*;

public class ExecutorDemo {
  public static void main(String[] args) throws InterruptedException {
    // Create a fixed thread pool with maximum three threads
    ExecutorService executor = Executors.newFixedThreadPool(3);

    // Submit runnable tasks to the executor
    executor.execute(new PrintChar('a', 100));
    executor.execute(new PrintChar('b', 1000));
    executor.execute(new PrintNum(100));

    // Shut down the executor
    executor.shutdown();
  }
}