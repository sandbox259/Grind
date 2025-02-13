package Threads;

public class Process {

    public static void main (String[] args){
        Sender send = new Sender();
        Receiver receive = new Receiver();

        send.initThread();
        receive.initThread();

        send.startThread();
        receive.startThread();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupt");
        }

        send.destoryThread();
        receive.destoryThread();

    }
    
}
