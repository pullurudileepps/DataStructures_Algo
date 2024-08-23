package Hashing;

import java.util.HashMap;
import java.util.Map;

public class sumHighestAndLowestFrequency {
    private static int optimizedSolution(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            if(freq < minFreq){
                minFreq = freq;
            }
            if(freq > maxFreq){
                maxFreq = freq;
            }
        }
        return maxFreq + minFreq;
    }
    private static int bruteForce(int[] nums){
        int n = nums.length;
        int maxFreq = 0;
        int minFreq = n;
        // Visited array
        boolean[] visited = new boolean[n];

        // First loop
        for (int i = 0; i < n; i++) {
            // Skip second loop if already visited
            if (visited[i]) continue;

            /* Variable to store frequency
            of current element */
            int freq = 0;

            // Second loop
            for (int j = i; j < n; j++) {
                if (nums[i] == nums[j]) {
                    freq++;
                    visited[j] = true;
                }
            }
            /* Update maximum and
            minimum frequencies */
            maxFreq = Math.max(maxFreq, freq);
            minFreq = Math.min(minFreq, freq);
        }
        // Return the required sum
        return maxFreq + minFreq;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3};
//        int ans = bruteForce(nums);
        int ans = optimizedSolution(nums);

        System.out.println("The sum of highest and lowest frequency in the array is: " + ans);
    }
}
