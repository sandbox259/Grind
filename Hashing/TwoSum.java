package Hashing;

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>(); // Store value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If complement exists in HashMap, return indices
            if (hashmap.containsKey(complement)) {
                return new int[] { hashmap.get(complement), i };
            }

            // Store the current number and its index in the HashMap
            hashmap.put(nums[i], i);
        }

        return new int[] {}; // Should never reach here as per problem constraints
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = twoSum(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
