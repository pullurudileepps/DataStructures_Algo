package Heap;


import java.util.*;

public class IPO {
    public static void main(String[] args) {
        int k = 3;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 2};
        int maximizedCapital = findMaximizedCapital(k, w, profits, capital);
        System.out.println(maximizedCapital);
    }
    //Using heap and greedily picking up projects
    //T.C : O(nlogn)
    //S.C : O(n)
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<int[]> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            projects.add(new int[]{capital[i], profits[i]});
        }
        projects.sort(Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        while (k-- > 0) {
            while (i < n && projects.get(i)[0] <= w) {
                maxProfitHeap.add(projects.get(i)[1]);
                i++;
            }
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            w += maxProfitHeap.poll();
        }
        return w;
    }
}
