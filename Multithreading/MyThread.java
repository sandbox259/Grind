package Multithreading;

public class MyThread extends Thread {
    @Override
    public void run(){
        for (int i = 0;i < 5; i++){
            System.out.println(currentThread().getName());
        }
    }

    public static void main (String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t1.wait();
        t2.start();
        }
    
}
