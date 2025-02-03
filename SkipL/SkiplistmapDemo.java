package SkipL;

import java.util.concurrent.ConcurrentSkipListMap;

public class SkiplistmapDemo {
    public static void main(String args[]) {
        ConcurrentSkipListMap<String, Integer> mp = new ConcurrentSkipListMap<>();
        mp.put("Apple", 2);
        mp.put("Banana", 3);
        mp.put("Guava", 6);
        mp.put("Kiwi", 4);

        System.out.println(mp.ceilingKey("Guava"));
        System.out.println(mp.firstKey());

    }

}
