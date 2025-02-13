package Hashing;
import java.util.Hashtable;
import java.util.concurrent.*;

class HashtableTask implements Runnable {
    private final Hashtable<Integer, Integer> map;
    private final int key;

    public HashtableTask(Hashtable<Integer, Integer> map, int key) {
        this.map = map;
        this.key = key;
    }

    @Override
    public void run() {
        map.put(key, key * 10);
        map.get(key);
        map.remove(key);
    }
}

class ConcurrentHashMapTask implements Runnable {
    private final ConcurrentHashMap<Integer, Integer> map;
    private final int key;

    public ConcurrentHashMapTask(ConcurrentHashMap<Integer, Integer> map, int key) {
        this.map = map;
        this.key = key;
    }

    @Override
    public void run() {
        map.put(key, key * 10);
        map.get(key);
        map.remove(key);
    }
}

public class MapPerformanceTest {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 10;
        int numTasks = 1000;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        
        // Hashtable Performance Test
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < numTasks; i++) {
            executor.execute(new HashtableTask(hashtable, i));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        long endTime = System.nanoTime();
        System.out.println("Hashtable Execution Time: " + (endTime - startTime) / 1e6 + " ms");
        
        // Reset Executor
        executor = Executors.newFixedThreadPool(numThreads);
        
        // ConcurrentHashMap Performance Test
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        startTime = System.nanoTime();
        for (int i = 0; i < numTasks; i++) {
            executor.execute(new ConcurrentHashMapTask(concurrentHashMap, i));
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        endTime = System.nanoTime();
        System.out.println("ConcurrentHashMap Execution Time: " + (endTime - startTime) / 1e6 + " ms");
    }
}
