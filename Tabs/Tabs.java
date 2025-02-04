package Tabs;


  class Browser {
    private String TabName;

    public void setName (String TabName) {
        this.TabName = TabName;
    }

    public String getName() {
        return TabName;
    }

    public void open(){
        System.out.println("Opening Tab" + " " + TabName);
        }
 }



class Tab implements Runnable {
    private String s;

    public Tab(String name) {
            this.s  = name;//TODO Auto-generated constructor stub
        }
    
        public void Runner(String chars) {
            this.s = chars;
        }
    
        @Override 
        public void run(){
    
            try {
                Thread.sleep(1000); // Simulate browsing time before closing
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("Closing tab ...." + s);
        }
    
    }
    
    
    public class Tabs {
        public static void main(String[] args) {
            System.out.println("Opening browser");
            Browser b1 = new Browser();
            b1.setName("Youtube");
            b1.open();
            Thread t1 = new Thread(new Tab(b1.getName()));
        t1.start();
        Browser b2 = new Browser();
        b2.setName("Netflix");
        b2.open();
        Thread t2 = new Thread(new Tab(b2.getName()));
        b1.open();
        t2.start();
        
    }
    
}
