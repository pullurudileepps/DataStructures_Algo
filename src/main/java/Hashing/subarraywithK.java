package Hashing;

import java.util.HashMap;

/**
 * Given an array of integers A and an integer B.
 * Find the total number of subarrays having sum equals to B.
 * 
 * 1 <= length of the array <= 50000
 * -1000 <= A[i] <= 1000
 * 
 * Return the total number of subarrays having sum equals to B.
 * 
 * A = [0, 0, 0]
 * B = 0
 * A = [1, 0, 1]
 * B = 1
 */
public class subarraywithK {

    public static void main(String[] args) {
        int[] A = { 0, 0, 0 };
        int B = 0;
        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int B) {
        int n = A.length;
        int[] PF = new int[n];
        PF[0] = A[0];
        for (int i = 1; i < n; i++) {
            PF[i] = PF[i - 1] + A[i];
        }
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (PF[i] == B) {
                count++;
            }
            if (map.containsKey(PF[i] - B)) {
                count += map.get(PF[i] - B);
            }
            if (map.containsKey(PF[i])) {
                map.put(PF[i], map.get(PF[i]) + 1);
            } else {
                map.put(PF[i], 1);
            }
        }
        return count;
    }
}