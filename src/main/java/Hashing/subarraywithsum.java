package Hashing;

import java.util.*;

/*
Problem Statement:

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.

Examples:
int A = {23,50,44,6,39,15,44,27,47,29,30,44,28,42,7,32,16,40,8,7,5,48,48,16,9,5,50,16,18,9,21,26,48,37,27,7,5,29,24,28,10,44,21,1,48,15,31,41,42,23,4,32,40,40,27,20,29,42,25,18,37,43,13,30,42,24,17,42,14,42,43,36,31,29,24,24,8,3,12,34,14,6};
int B = 62;

int A = {1, 2, 3, 4, 5}
B = 5
*/
public class subarraywithsum {

    public static void main(String[] args) {
        int[] A = { 23, 50, 44, 6, 39, 15, 44, 27, 47, 29, 30, 44, 28, 42, 7, 32, 16, 40, 8, 7, 5, 48, 48, 16, 9, 5, 50,
                16, 18, 9, 21, 26, 48, 37, 27, 7, 5, 29, 24, 28, 10, 44, 21, 1, 48, 15, 31, 41, 42, 23, 4, 32, 40, 40,
                27, 20, 29, 42, 25, 18, 37, 43, 13, 30, 42, 24, 17, 42, 14, 42, 43, 36, 31, 29, 24, 24, 8, 3, 12, 34,
                14, 6 };
        int B = 62;
        System.out.println(Arrays.toString(bruteForce(A, B)));
        System.out.println();
    }

    public static int[] solve(int[] A, int B) {
        int n = A.length;
        int start = 0;
        int end = 0;
        int sum = 0;
        // Iterate N Times
        for (end = 0; end < n; end++) {
            sum += A[end];

            // Q times
            while (sum > B && start <= end) {
                sum -= A[start];
                start++;
            }

            if (sum == B) {
                // BIG O(end-start+1) times
                int[] ans = new int[end - start + 1];
                for (int k = start; k <= end; k++) {
                    ans[k - start] = A[k];
                }
                return ans;
            }
        }
        return new int[] { -1 };
    }

    public static int[] bruteForce(int[] A, int B) {
        int n = A.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        // Iterate N Times
        for (i = 0; i < n; i++) {
            sum = 0;
            for (j = i; j < n; j++) {
                sum += A[j];
                if (sum == B) {
                    int[] ans = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        ans[k - i] = A[k];
                    }
                    return ans;
                }
            }
        }
        return new int[] { -1 };
    }
}
