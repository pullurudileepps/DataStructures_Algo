package Arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContinuousSubArraySum {
    public static void main(String[] args) {
        int[] nums = {23, 2, 6, 4, 7};
        int k = 13;
        boolean ans = checkSubarraySum(nums, k);
        System.out.println(ans);
    }
    private static boolean checkSubarraySum(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int remainder = sum % k;
            if(map.containsKey(remainder)){
                Integer IndexPos = map.get(remainder);
                if(i - IndexPos >= 2){
                    return true;
                }
            }
            else{
                map.put(remainder, i);
            }
        }
        return false;
    }
}

/*
523. Continuous Subarray Sum
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

A good subarray is a subarray where:

its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
Note that:

A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

Note :
it should be continuous
subarray size  >= 2
N%K == 0
Input: nums = [23,2,4,6,7], k = 6//true
Input: nums = [23,2,6,4,7], k = 6//true
Input: nums = [23,2,6,4,7], k = 13//false
Input: nums = [1,2,3], k = 6 //true

dry run:
Map:
0, -1
[23,2,6,4,7]
i = 0; sum = 23 % 6 = 5
Map 5, 0;
i = 1; sum = 23 + 2 % 6 = 1
Map 1, 1
i = 2; sum = 23 + 2 + 6 = 1;
1 existing in the map at 1st index
i - map index => 2 - 1 >= 2 false;
i = 3 sum = 23 + 2 + 6 + 4 % 6 = 5
i = 3; 5 existing at 0th pos in the map
3 - 0 >=2 condition satisfy return true
 */
