package Math;

import java.util.HashSet;
import java.util.Set;

//633. Sum of Square Numbers
public class sumofSquareNumbers {
    public static boolean judgeSquareSum(int c) {
        int high = (int) Math.sqrt(c);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= high; i++) {
            set.add(i * i);
        }
        for (int i = 0; i <= high; i++) {
            if (set.contains(c - (i * i))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int c = 5;
        boolean b = judgeSquareSum(c);
        System.out.println(b);
    }
}
