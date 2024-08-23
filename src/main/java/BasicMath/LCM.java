package BasicMath;

public class LCM {
    public static void main(String[] args) {
        int n1 = 4; int n2 = 6;
        System.out.println(solution(n1,n2));
    }
    public static int solution(int n1, int n2) {
        return (n1 * n2)/GCD(n1, n2);
    }

    private static int GCD(int n1, int n2){
        while(n1 != 0 && n2 != 0){
            if(n1 > n2){
                n1 = n1 % n2;
            }
            else{
                n2 = n2 % n1;
            }
        }
        if(n1 == 0) return n2;
        return n1;
    }
}
