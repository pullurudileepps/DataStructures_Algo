package String;

import java.util.*;

class frequencySort {
    public static List<Character> solution(String s) {
        // Frequency array for characters 'a' to 'z'
        Pair[] freq = new Pair[26];
        for (int i = 0; i < 26; i++) {
            freq[i] = new Pair(0, (char) (i + 'a'));
        }

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a'].freq++;
        }

        // Sort based on frequency (descending) and alphabetically (ascending)
        Arrays.sort(freq, (p1, p2) -> {
            if (p1.ch == p2.ch)
                return p1.ch - p2.ch;
            return p2.freq - p1.freq;
        });

        // Collect result
        List<Character> result = new ArrayList<>();
        for (Pair p : freq) {
            if (p.freq > 0)
                result.add(p.ch);
        }
        return result;
    }

    // Helper class to store frequency and character
    static class Pair {
        int freq;
        char ch;

        Pair(int f, char i) {
            this.freq = f;
            this.ch = i;
        }
    }

    // Main method to test the function
    public static void main(String[] args) {
        String s = "tree";
        List<Character> result = solution(s);
        System.out.println(result);
    }
}
