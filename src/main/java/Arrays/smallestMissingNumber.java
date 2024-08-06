package Arrays;

import java.util.*;

/*
 find the missing positive integer, which is in unsorted format, and find the smallest non-negative number
 missing from the array
 */
public class smallestMissingNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(8, 10, 1, -3, 2, -5, 0, 6, 4);
        System.out.println(Optimise(list));
        System.out.println(SwapApproach(list));
    }


    private static List<Integer> SwapApproach(List<Integer> list) {
        int size = list.size() - 1;
        for (int i = 0; i < list.size(); i++) {
            while (list.get(i) >= 0 && list.get(i) <= size) {
                int index = list.get(i);//4
                if(index == i){
                    break;
                }
                int temp = list.get(index);//get index of 4
                list.set(index, index);
                list.set(i, temp);
            }
        }
        return list;
    }

    private static int Optimise(List<Integer> list) {
        //T.C: O(N)
        //S.C: O(N)
        Set<Integer> set = new HashSet<>();
        for (Integer arr : list) {
            if (arr >= 0) {
                set.add(arr);
            }
        }
        Iterator<Integer> itr = set.iterator();
        int missingValue = 0;
        while (itr.hasNext()) {
            if (!itr.next().equals(missingValue)) {
                break;
            }
            missingValue++;
        }
        return missingValue;
    }
}
