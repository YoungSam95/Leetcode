package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3305. 元音辅音字符串计数 I
 */
public class Solution3305 {
    public int countOfSubstrings(String word, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int n = word.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            Set<Character> occur = new HashSet<>();
            int consonants = 0;
            for (int j = i; j < n; j++) {
                if (vowels.contains(word.charAt(j))) {
                    occur.add(word.charAt(j));
                } else {
                    consonants++;
                }
                if (occur.size() == 5 && consonants == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
