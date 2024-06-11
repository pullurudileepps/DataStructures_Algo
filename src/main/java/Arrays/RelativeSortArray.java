package Arrays;

import java.util.*;

public class RelativeSortArray {
    //T.C : O(NLogn)
    //S.C : O(N)
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int arr : arr1) map.put(arr, map.getOrDefault(arr, 0) + 1);
        int j = -1;
        for (int arr : arr2) {
            while (map.get(arr) > 0) {
                arr1[++j] = arr;
                map.put(arr, map.get(arr) - 1);
            }
        }
        List<Integer> temp = new ArrayList<>();
        map.entrySet().stream()
                .filter(val -> val.getValue() > 0)
                .forEach(x -> temp.add(x.getKey()));
        Collections.sort(temp);
        for (int num : temp) {
            arr1[++j] = num;
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1 = {28, 6, 22, 8, 44, 17};
        int[] arr2 = {22, 28, 8, 6};
        int[] result = relativeSortArray(arr1, arr2);
        int[] Output = {22, 28, 8, 6, 17, 44};
        boolean ans = Arrays.compare(Output, result) == 0;
        System.out.println(ans);
    }
}
/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.



Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
Example 2:

Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
Output: [22,28,8,6,17,44]
 */
