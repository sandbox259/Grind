package Hashing;

import java.util.concurrent.*;

class ServiceThread implements Runnable {
    private ConcurrentHashMap<Integer, String> map;
    private int threadId;

    public ServiceThread(ConcurrentHashMap<Integer, String> map, int threadId) {
        this.map = map;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            int key = threadId * 10 + i;
            map.put(key, "Value" + key);
            System.out.println("Thread " + threadId + " inserted: " + key);

            String value = map.get(key);
            System.out.println("Thread " + threadId + " retrieved: " + key + " -> " + value);
        }
    }
}

public class Hashtest {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.execute(new ServiceThread(concurrentMap, i));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Map: " + concurrentMap);
    }
}
