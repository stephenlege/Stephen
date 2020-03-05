/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MP9_HW;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Problem10_concurrency_lock {

    private static SetClass set = new SetClass();

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new AddTask());
        executor.execute(new IterateTask());
        executor.shutdown();
    }

    private static class AddTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("Thread 1");
                set.addToSet();
            }
        }

    }

    private static class IterateTask implements Runnable {

        @Override
        public void run() {
            while (true) {
                System.out.println("Thread 2");
                set.iteratorSet();
            }
        }

    }

    static class SetClass {

        Set<Integer> set = new HashSet<>();
        private static Lock lock = new ReentrantLock();

        public void addToSet() {
            lock.lock();
            try {
                int num = (int) (Math.random() * 100) + 1;
                set.add(num);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            } finally {
                lock.unlock();
            }
        }

        public void iteratorSet() {
            lock.lock();
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException ex) {

            } finally {
                lock.unlock();
            }
        }
    }
}
