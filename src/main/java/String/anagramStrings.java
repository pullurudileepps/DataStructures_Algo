package String;

class Solution {
    public boolean anagramStrings(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] freq = new int[127];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (freq[t.charAt(i)] > 0) {
                freq[t.charAt(i)]--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "INTEGER";
        String str2 = "TEGERNI";
        boolean result = solution.anagramStrings(str1, str2);
        System.out.println(result ? "True" : "False");
    }
}
