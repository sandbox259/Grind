package Maps;


import java.util.HashMap;

import java.util.Map;

public class Maps {
    public static void main(String args[]) {
        Map<String, Integer> students = new HashMap<>();
        students.put("Saad", 71);
        students.put("Kkrishna", 54);
        students.put("Sharma", 45);
        students.put("Mishra", 99);

        System.out.println(students.keySet()); // print all keys

    }
}
