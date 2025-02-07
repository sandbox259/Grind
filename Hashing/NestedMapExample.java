package Hashing;

import java.util.HashMap;
import java.util.Map;



public class NestedMapExample {
    public static void main (String Args[]){
        Map<String , Map<String, Integer>> students = new HashMap<>();

    Map<String, Integer> bobGrades = new HashMap<>();
    Map<String, Integer> aliceGrades = new HashMap<>();
    aliceGrades.put("Math", 90);
    aliceGrades.put("Science", 75);
    aliceGrades.put("English", 78);
    students.put("Alice", aliceGrades);
    students.put("Bob", bobGrades);

    System.out.println("Initial Mapping"+ aliceGrades );
    System.out.println("Key Set:" + aliceGrades.entrySet());
    System.out.println(getGrade(students, "Alice", "English"));
    System.out.println(getGrade(students, "Bob", "Science"));
    System.out.println(getGrade(students, "Charlie", "Math"));
    }

    public static String getGrade(Map<String, Map<String, Integer>> students, String studentName, String subject) {
        if (students.containsKey(studentName)){
            Map<String, Integer> subjects = students.get(studentName);
            //System.out.println("subjects" + subjects);
            if (subjects.containsKey(subject)){
                return studentName + "'s grade in " + subject + " is " + subjects.get(subject);
            }
            return subject + " not found for " + studentName;
        }
        return "Student " + studentName + " not found";
}

    
    
    
}



