package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable {
    private final int taskId;

    public WorkerThread(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is executing task " + taskId);
        try {
            Thread.sleep(2000); // Simulating work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished task " + taskId);
    }
}

class ThreadStateDemo extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Thread State: " + getState()); // RUNNABLE
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadPoolAndStateDemo {
    public static void main(String[] args) {
        // Demonstrating Thread States
        ThreadStateDemo thread = new ThreadStateDemo();
        System.out.println("Thread State: " + thread.getState()); // NEW
        thread.start();
        try {
            Thread.sleep(500);
            System.out.println("Thread State: " + thread.getState()); // TIMED_WAITING
            thread.join();
            System.out.println("Thread State: " + thread.getState()); // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Demonstrating Thread Pools
        ExecutorService executor = Executors.newFixedThreadPool(3); // Thread pool with 3 threads
        for (int i = 1; i <= 5; i++) {
            executor.execute(new WorkerThread(i));
        }
        executor.shutdown();
    }
}
