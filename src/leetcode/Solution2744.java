package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2744. 最大字符串配对数目
 */
public class Solution2744 {
    public int maximumNumberOfStringPairs(String[] words) {
        int n = words.length;
        int ans = 0;
        Set<Integer> seen = new HashSet<Integer>();
        for (int i = 0; i < n; ++i) {
            if (seen.contains(words[i].charAt(1) * 100 + words[i].charAt(0))) {
                ++ans;
            }
            seen.add(words[i].charAt(0) * 100 + words[i].charAt(1));
        }
        return ans;
    }
}
