package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3120. 统计特殊字母的数量 I
 */
public class Solution3120 {
    public int numberOfSpecialChars(String word) {
        Set<Character> s = new HashSet<>();
        for (char c : word.toCharArray()) {
            s.add(c);
        }
        int ans = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            if (s.contains(c) && s.contains((char)(c - 'a' + 'A'))) {
                ans++;
            }
        }
        return ans;
    }
}
