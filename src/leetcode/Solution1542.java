package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1542. 找出最长的超赞子字符串
 */
public class Solution1542 {
    public int longestAwesome(String s) {
        int n = s.length();
        Map<Integer, Integer> prefix = new HashMap<Integer, Integer>();
        prefix.put(0, -1);
        int ans = 0;
        int sequence = 0;
        for (int j = 0; j < n; ++j) {
            int digit = s.charAt(j) - '0';
            sequence ^= (1 << digit);
            if (prefix.containsKey(sequence)) {
                ans = Math.max(ans, j - prefix.get(sequence));
            } else {
                prefix.put(sequence, j);
            }
            for (int k = 0; k < 10; ++k) {
                if (prefix.containsKey(sequence ^ (1 << k))) {
                    ans = Math.max(ans, j - prefix.get(sequence ^ (1 << k)));
                }
            }
        }
        return ans;
    }
}
