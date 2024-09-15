package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class Most_Profit_Assigning_Work {

    public static void main(String[] args) {
        int[] difficulty = { 2, 4, 6, 8, 10 };
        int[] profit = { 10, 20, 30, 40, 50 };
        int[] worker = { 4, 5, 6, 7 };
        int ans = maxProfitAssignment(difficulty, profit, worker);
        System.out.println(ans);
    }

    // T.C : O(N + M)Logn
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;
        List<int[]> vec = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vec.add(new int[] { difficulty[i], profit[i] });
        }
        vec.sort((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < vec.size(); i++) {
            vec.get(i)[1] = Math.max(vec.get(i)[1], vec.get(i - 1)[1]);
        }
        return getTotalProfit(worker, m, vec);
    }

    private static int getTotalProfit(int[] worker, int m, List<int[]> vec) {
        int totalProfit = 0;
        for (int i = 0; i < m; i++) {
            int workerDiffLevel = worker[i];
            int l = 0, r = vec.size() - 1;
            int maxProfit = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (vec.get(mid)[0] <= workerDiffLevel) {
                    maxProfit = Math.max(maxProfit, vec.get(mid)[1]);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            totalProfit += maxProfit;
        }
        return totalProfit;
    }
}