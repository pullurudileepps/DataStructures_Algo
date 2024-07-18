package PreFix;

public class maxSumContiguousSubarray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, -10};//ans:10
        //{-2, 1, -3, 4, -1, 2, 1, -5, 4} //ans:6
        int n = A.length;
        int cur = A[0];
        int ans_max = A[0];
        for (int i = 1; i < n; i++) {
            cur = Math.max(A[i], cur + A[i]);
            ans_max = Math.max(ans_max, cur);
        }
        System.out.println(ans_max);
    }
}
