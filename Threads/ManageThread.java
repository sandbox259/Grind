package Threads;

abstract class ManageThread implements Runnable {
    private Thread th;
    private boolean running = false;
    private String threadName;

    public ManageThread(String name){
        this.threadName = name;
    }

    public void initThread(){
        th = new Thread (this, threadName);
        running = true;
        System.out.println(threadName + " initialized.");
    }

    public void startThread(){
        if(th != null){
            th.start();
            System.out.println(threadName + " started.");
        }

    }

    public void destoryThread(){
        running = false;
        System.out.println(threadName + " is stopping.");
    }

    public void doJob(){
        System.out.println(threadName+ " is executing task.");
    }


@Override
    public void run(){
        while(running){
            doJob();
            try{
                Thread.sleep(1000);
            } catch( InterruptedException e){
                System.out.println(threadName + "interrupted");
            }
        }
        System.out.println(threadName + " stopped.");

    }




    
}
