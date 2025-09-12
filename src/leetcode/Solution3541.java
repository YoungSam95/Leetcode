package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3541. 找到频率最高的元音和辅音
 */
public class Solution3541 {
    public int maxFreqSum(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }
        int vowel = 0, consonant = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (isVowel(ch)) {
                vowel = Math.max(vowel, mp.getOrDefault(ch, 0));
            } else {
                consonant = Math.max(consonant, mp.getOrDefault(ch, 0));
            }
        }
        return vowel + consonant;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
