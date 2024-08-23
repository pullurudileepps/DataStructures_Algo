package String;

public class isomorphicString {
    public static boolean isomorphic(String s, String t) {
        // Arrays to store the last seen positions of characters in s and t
        int[] m1 = new int[127], m2 = new int[127];

        // Length of the string
        int n = s.length();

        // Iterate through each character in the strings
        for (int i = 0; i < n; ++i) {
            // If the last seen positions of the current characters don't match, return false
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;

            // Update the last seen positions
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }

        // If all characters match, return true
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        String s = "apple";
        String t = "bbnbm";
        if (isomorphic(s, t)) {
            System.out.println("Strings are isomorphic.");
        } else {
            System.out.println("Strings are not isomorphic.");
        }
    }
}
