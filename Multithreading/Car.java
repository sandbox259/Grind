package Multithreading;



class Riding {
    {
        //World w1 = new World();
        System.out.println("Car left for ride");

    }
}

class User implements Runnable  {

    @Override
    public void run()
    {
        System.out.println("User has taken the ride");
    }

}


class Suresh extends User{
    User suresh = new User();

    @Override
    public void run(){
    System.out.println("Suresh has taken the ride");
    }

}


public class Car {
    public static void main(String[] args) {
        User c1 = new User();
        Thread t1 = new Thread (c1);
        Suresh c2 = new Suresh();
        Thread t2 = new Thread(c2);


        t2.getState();
        t2.start();
        t1.start();
        t1.getState();
    }

    
}
 