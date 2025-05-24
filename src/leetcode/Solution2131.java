package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2131. 连接两字母单词得到的最长回文串
 */
public class Solution2131 {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        int res = 0;
        boolean mid = false;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            String word = entry.getKey();
            int cnt = entry.getValue();
            String rev = "" + word.charAt(1) + word.charAt(0);
            if (word.equals(rev)) {
                if (cnt % 2 == 1) {
                    mid = true;
                }
                res += 2 * (cnt / 2 * 2);
            } else if (word.compareTo(rev) > 0) {
                res += 4 * Math.min(freq.getOrDefault(word, 0), freq.getOrDefault(rev, 0));
            }
        }
        if (mid) {
            res += 2;
        }
        return res;
    }
}
