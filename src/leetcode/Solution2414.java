package leetcode;

/**
 * 2414. 最长的字母序连续子字符串的长度
 */
public class Solution2414 {
    public int longestContinuousSubstring(String s) {
        int res = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) + 1) {
                cur++;
            } else {
                cur = 1;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
