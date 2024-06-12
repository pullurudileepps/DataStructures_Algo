package Arrays;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    //T.C : O(N)
    //S.C: O(1)
    public static void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (mid <= right) {
            if (nums[mid] == 0) {
                int temp = nums[mid];
                nums[mid] = nums[left];
                nums[left] = temp;
                mid++;
                left++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
    }
}