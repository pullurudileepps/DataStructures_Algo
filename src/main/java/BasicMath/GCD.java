package BasicMath;

public class GCD {
    public static void main(String[] args) {
        int n1 = 4;
        int n2 = 6;
        System.out.println(EuclideanAlgo(n1, n2));
        System.out.println(BruteForce(n1, n2));
    }
    private static int EuclideanAlgo(int n1, int n2) {
        while (n1 != 0 && n2 != 0) {
            if (n1 > n2) {
                //n1 = n1 - n2;//it is take more iterations
                n1 = n1 % n2;
            } else {
                //n2 = n2 - n1;//it is take more iterations
                n2 = n2 % n1;
            }
        }
        if (n2 == 0) return n1;
        return n2;
    }

    //T.C: O(min(n1,n2));
    private static int BruteForce(int n1, int n2) {
        int gcd = 1;
        for (int i = 2; i <= Math.min(n1, n2); i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}