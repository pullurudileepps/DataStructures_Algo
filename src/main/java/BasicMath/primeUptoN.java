package BasicMath;

public class primeUptoN {
    public static void main(String[] args) {
        int n = 5;
        int count = 0;
        for(int i=2;i<=n;i++){
            if(isPrime(i)){
                count++;
            }
        }
        System.out.println(count);
    }
    private static boolean isPrime(int n){
        int count = 0;
        for(int i=1;i<=n;i++){
            if(n%i == 0){
                count++;
            }
        }
        if(count == 2) return true;
        return false;
    }
}
