package Oops;

class Rocket {
    protected String name;
    protected int fuel;

    Rocket(String name) {
        this.name = name;
        this.fuel = 50; // Initial fuel level
    }

    void getName(String s) {
        this.name = s;
    }

    void refuel(int amount) {
        fuel += amount;
        System.out.println(name + " refueled. Current fuel: " + fuel + "%");
    }
}

class Earth extends Rocket {
    Earth(String name) {
        super(name);
    }

    void inplanet() {
        System.out.println(name + " is on Earth");
    }

    void outplanet() {
        System.out.println(name + " is exiting Earth");
    }
}

class Mars extends Rocket {
    Mars(String name) {
        super(name);
    }

    void inplanet() {
        System.out.println(name + " is on Mars");
    }

    void outplanet() {
        System.out.println(name + " is exiting Mars");
    }
}

class FuelTanker extends Thread {
    private Rocket rocket;

    FuelTanker(Rocket rocket) {
        this.rocket = rocket;
    }

    @Override
    public void run() {
        System.out.println("Fuel tanker is refueling " + rocket.name);
        rocket.refuel(50); // Refuel with 50% fuel
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("Exception occured");
        }
    }
}

class MissionThread extends Thread {
    private Rocket rocket;

    MissionThread(Rocket rocket) {
        this.rocket = rocket;
    }

    @Override
    public void run() {
        System.out.println(rocket.name + " is leaving for the mission...");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Rocket Mission Control");

        Mars rocket1 = new Mars("ISRO-1");
        Earth rocket2 = new Earth("NASA-2");

        MissionThread mission1 = new MissionThread(rocket1);
        MissionThread mission2 = new MissionThread(rocket2);

        FuelTanker tanker1 = new FuelTanker(rocket1);
        FuelTanker tanker2 = new FuelTanker(rocket2);

        rocket1.inplanet();
        rocket2.inplanet();

        tanker1.start();
        tanker2.start();
        // tanker1.wait();

        try {
            tanker1.join();
            tanker2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        mission1.start();
        mission2.start();

        try {
            mission1.join();
            mission2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        rocket1.outplanet();
        rocket2.outplanet();

    }
}
