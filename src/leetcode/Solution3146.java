package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3146. 两个字符串的排列差
 */
public class Solution3146 {
    public int findPermutationDifference(String s, String t) {
        Map<Character, Integer> char2index = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char2index.put(s.charAt(i), i);
        }
        int sum = 0;
        for (int i = 0; i < t.length(); ++i) {
            sum += Math.abs(i - char2index.get(t.charAt(i)));
        }
        return sum;
    }
}
