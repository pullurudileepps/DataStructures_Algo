package Arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumsDivisibleByK {
    // T.C: O(N)
    // S.C: O(N)
    private static int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int reminder = sum % k;
            if (reminder < 0)
                reminder += k;
            if (map.containsKey(reminder)) {
                count += map.get(reminder);
            }
            map.put(reminder, map.getOrDefault(reminder, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 2, -6, 3, 1, 2, 8, 2, 1 };
        int k = 7;
        int ans = subarraysDivByK(nums, k);
        int ans1 = BrutesubarraysDivByK(nums, k);
        System.out.println(ans);
        System.out.println(ans1);
    }

    // T.C : O(N^2)
    // S.C : O(0)
    // TLE
    private static int BrutesubarraysDivByK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
/*
 * Given an integer array nums and an integer k, return the number of non-empty
 * subarrays that have a sum divisible by k.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * Example 1:
 * 
 * Input: nums = [4,5,0,-2,-3,1], k = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by k = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * Example 2:
 * 
 * Input: nums = [5], k = 9
 * Output: 0
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * 2 <= k <= 104
 */