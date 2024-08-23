package BasicMath;

public class isPrime {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(bruteForce(n));
        System.out.println(OptimizedApproach(n));
    }
    //T.C : O(N)
    private static boolean bruteForce(int n){
        for(int i=2;i<n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    //T.C: O(Sqrt(n))
    private static boolean OptimizedApproach(int n){
        for(int i=2;i*i<=n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
