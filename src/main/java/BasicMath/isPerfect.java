package BasicMath;

/*
Check for perfect number
You are given an integer n. You need to check if the number is a perfect number or not.
 Return true is it is a perfect number, otherwise return false.
A perfect number is a number whose proper divisors add up to the number itself.

Input: n = 6
Output: true
Explanation: Proper divisors of 6 are 1, 2, 3. 1 + 2 + 3 = 6.
*/
public class isPerfect {
    public static void main(String[] args) {
        int n = 6;
        int total = optimized(n);
        System.out.println(total == n);
    }

    // T.C : O(N)
    // private static int sumPerfectNumber(int n){
    // int sum = 0;
    // int size = n-1;
    // for(int i = 1;i<size;i++){
    // if(n % i == 0){
    // sum = sum + i;
    // }
    // }
    // return sum;
    // }
    // T.C : O(Sqrt(n))
    private static int optimized(int n) {
        int sum = 0;
        for (int i = 1; i * i < n; i++) {
            if (n % i == 0) {
                sum = sum + i;
                if (n != (n / i)) {
                    sum = sum + (n / i);
                }
            }
        }
        return sum;
    }
}
