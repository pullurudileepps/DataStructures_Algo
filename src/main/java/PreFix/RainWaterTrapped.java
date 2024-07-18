package PreFix;

/*
Problem Description
Imagine a histogram where the bars' heights are given by the array A. Each bar is of uniform width, which is 1 unit. When it rains, water will accumulate in the valleys between the bars.

Your task is to calculate the total amount of water that can be trapped in these valleys.

Example:

The Array A = [5, 4, 1, 4, 3, 2, 7] is visualized as below. The total amount of rain water trapped in A is 11.

 */
public class RainWaterTrapped {
    public static void main(String[] args) {
        int[] A = {5, 4, 1, 4, 3, 2, 7};
        int size = A.length;
        //get the max value in reverse fashion
        int rightMax = A[size - 1];
        int[] rightMaxArray = new int[size];
        for (int i = size-2; i >= 0; i--) {
            rightMax = Math.max(rightMaxArray[i], rightMax);
            rightMaxArray[i] = rightMax;
        }
        //calculate the min distance from right to left
        int ans = 0;
        int leftMax = 0;
        for (int i = 0; i < size; i++) {
            leftMax = Math.max(leftMax, A[i]);
            int sum = Math.min(leftMax, rightMaxArray[i]) - A[i];
            if (sum > 0) {
                ans += sum;
            }
        }
        System.out.println(ans);
    }
}
