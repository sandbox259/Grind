package Threads;

public class Sender extends ManageThread {

    public Sender(){
        super("SenderThread");
    }

    @Override
    public void doJob(){
        System.out.println(" Sender: Sending Message");
    }
    
}
