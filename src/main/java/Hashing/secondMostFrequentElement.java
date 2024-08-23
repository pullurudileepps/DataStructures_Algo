package Hashing;

import java.util.HashMap;
import java.util.Map;
/*
* Second highest occurring element
* Given an array of n integers, find the second most frequent element in it.
* If there are multiple elements that appear a maximum number of times,
* find the smallest of them. If second most frequent element does not exist return -1.
* Input: arr = [1, 2, 2, 3, 3, 3]
* Output: 2
* Input: arr = [4, 4, 5, 5, 6, 7]
* Output: 6
 */
public class secondMostFrequentElement {
    private static int bruteForce(int[] nums) {

        // Variable to store the size of array
        int n = nums.length;

        /* Variable to store maximum frequency
        and second Max frequency */
        int maxFreq = 0;
        int secMaxFreq = 0;

        /* Variable to store elements with most
        and second most frequency */
        int maxEle = -1, secEle = -1;

        // Visited array
        boolean[] visited = new boolean[n];

        // First loop
        for(int i = 0; i < n; i++) {
            // Skip second loop if already visited
            if(visited[i]) continue;

            /* Variable to store frequency
            of current element */
            int freq = 0;

            // Second loop
            for(int j = i; j < n; j++) {
                if(nums[i] == nums[j]) {
                    freq++;
                    visited[j] = true;
                }
            }

            /* Update variables if new element
            having highest frequency or second
            highest frequency is found */
            if(freq > maxFreq) {
                secMaxFreq = maxFreq;
                maxFreq = freq;
                secEle = maxEle;
                maxEle = nums[i];
            }
            else if(freq == maxFreq) {
                maxEle = Math.min(maxEle, nums[i]);
            }
            else if(freq > secMaxFreq) {
                secMaxFreq = freq;
                secEle = nums[i];
            }
            else if(freq == secMaxFreq) {
                secEle = Math.min(secEle, nums[i]);
            }

        }
        return secEle;
    }
    private static int optimizedSolution(int[] nums){
        int maxFreq = 0;
        int secMaxFreq = 0;
        int maxEle = -1;
        int secEle = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int ele = entry.getKey();
            int freq = entry.getValue();
            if(freq > maxFreq){
                secMaxFreq = maxFreq;
                secEle = maxEle;
                maxFreq = freq;
                maxEle = ele;
            }else if(freq == maxFreq){
                maxEle = Math.min(maxEle, ele);
            }else if(freq > secMaxFreq){
                secMaxFreq = freq;
                secEle = ele;
            }else if(freq == secMaxFreq){
                secEle = Math.min(secEle, ele);
            }
        }
        return secEle;
    }

    public static void main(String[] args) {
        int[] nums = {4, 4, 5, 5, 6, 7};
//        int ans = bruteForce(nums);
        int ans = optimizedSolution(nums);

        System.out.println("The second highest occurring element in the array is: " + ans);
    }
}
