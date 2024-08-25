public class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)) return true;
        int size = s.length();
        int i = 0;
        while(i < size){
            s = s.substring(1) + s.charAt(0);
            if(s.equals(goal)){
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rotateString("abcde", "cdeab"));  
        System.out.println(sol.rotateString("abcde", "abced"));  
    }
}
