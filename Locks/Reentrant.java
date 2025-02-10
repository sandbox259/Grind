package Locks;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private int counter = 0;
    private Lock lock1 = new ReentrantLock(); 

    public void increment(){
        lock1.lock();
        try{
            counter++;
            System.out.println(Thread.currentThread().getName() + ": Counter = " + counter);
        } finally {
            lock1.unlock();
        }
    }
}

public class Reentrant{
    public static void main(String[] args){
        SharedResource shared = new SharedResource();

        Thread thread1 = new Thread(() -> {
            for(; ;){
                shared.increment();
                try {
                    Thread.sleep(1000); // Pause for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1");

        Thread thread2 = new Thread(()-> {
            for(int i =0; i<5; i++){
                shared.increment();
            }
        }, "Thread-2");

        //thread1.start();
        thread2.start();
        thread1.start();

    }
};
    

