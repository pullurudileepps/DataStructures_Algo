package Hashing;

import java.util.HashMap;
import java.util.Map;

/*
Highest occurring element in an array
* Given an array of n integers, find the most frequent element in it i.e.,
* the element that occurs the maximum number of times. If there are multiple elements that appear a
*  maximum number of times, find the smallest of them.
Please note that this section might seem a bit difficult without prior knowledge on what hashing is,
* we will soon try to add basics concepts for your ease! If you know the concepts already please go
* ahead to give a shot to the problem. Cheers!
*/
public class mostFrequentElement {

    //T.C (N^2)
    private static int bruetForce(int[] nums) {

        // Variable to store the size of array
        int n = nums.length;

        // Variable to store maximum frequency
        int maxFreq = 0;

        /* Variable to store element
        with maximum frequency */
        int maxEle = 0;

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

            /* Update variables if new element having
            highest frequency is found */
            if (freq > maxFreq) {
                maxFreq = freq;
                maxEle = nums[i];
            } else if (freq == maxFreq) {
                maxEle = Math.min(maxEle, nums[i]);
            }
        }
        return maxEle;
    }

    private static int optimized(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxEle = 0;
        int maxFreq = 0;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int ele = entry.getKey();
            int freq = entry.getValue();
            if(freq > maxFreq){
                maxFreq = freq;
                maxEle = ele;
            }else if(freq == maxFreq){
                maxEle = Math.min(maxEle, ele);
            }
        }
        return maxEle;
    }
    public static void main(String[] args) {
        int[] nums = {4, 4, 5, 5, 6};
        int ans = bruetForce(nums);
        int ans2 = optimized(nums);
        System.out.println("The highest occurring element in the array is: " + ans + " OR " + ans2);
    }
}
