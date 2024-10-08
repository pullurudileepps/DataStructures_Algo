package PreFix;

import java.util.Arrays;

/*
There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin(according to their faith and ability) to some K beggars sitting next to each other.

Given the amount P donated by each devotee to the beggars ranging from L to R index, where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.
For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, given by the 2D array B
 */
public class ContinueSumQuery {
    public static void main(String[] args) {
        int A = 5;
        int[][] B = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
        int[] ans = solve(A, B);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] solve(int a, int[][] b) {
        int[] prefix = new int[a];
        int size = b.length;
        for (int i = 0; i < size; i++) {
            int L = b[i][0] - 1;
            int R = b[i][1] - 1;
            int P = b[i][2];
            while (L <= R) {
                prefix[L] = prefix[L] + P;
                L++;
            }
        }
        return prefix;
    }
}
