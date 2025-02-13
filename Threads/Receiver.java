package Threads;

public class Receiver extends ManageThread{
    
    public Receiver(){
        super("ReceiverThread");
    }
    @Override
    public void doJob(){
    System.out.println("Receiver: Receiving Message");
    }
}