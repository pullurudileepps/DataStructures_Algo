package String;
/*
* Largest odd number in a string
* Given a string s, representing a large integer,
*  the task is to return the largest-valued odd integer (as a string)
* that is a substring of the given string s.

* The number returned should not have leading zero's. But the given input
* string may have leading zero.

* Example 1
Input : s = "5347"
Output : "5347"
Explanation : The odd numbers formed by given strings are --> 5, 3, 53, 347, 5347.
So the largest among all the possible odd numbers for given string is 5347.
 */

public class largeOddNumString {
    public static void main(String[] args) {
        String num = "504";
        String result = largeOddNum(num);
        System.out.println("Largest odd number: " + result);
    }

    public static String largeOddNum(String s) {
        int rightInd = -1;
        int n = s.length() - 1;
        for (int i = n; i >= 0; i--) {
            if (s.charAt(i) % 2 == 1) {
                rightInd = i;
                break;
            }
        }
        if (rightInd == -1)
            return "";

        int leftInd = 0;
        while (leftInd <= rightInd && s.charAt(leftInd) == '0')
            leftInd++;

        return s.substring(leftInd, rightInd + 1);
    }

    // this is not correct way to solve this question
    // private static String BruteForce(String s) {
    // int maxOdd = -1;
    // int n = s.length() - 1;
    // for (int i = 0; i <= n; i++) {
    // for (int j = i; j <= n; j++) {
    // int num = Integer.parseInt(s.substring(i, j + 1));
    // if (num % 2 == 1) {
    // maxOdd = Math.max(maxOdd, num);
    // }
    // }
    // }
    // return maxOdd == -1 ? "" : Integer.toString(maxOdd);
    // }
}
