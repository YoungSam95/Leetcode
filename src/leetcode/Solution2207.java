package leetcode;

/**
 * 2207. 字符串中最多数目的子序列
 */
public class Solution2207 {
    public long maximumSubsequenceCount(String s, String pattern) {
        long res = 0;
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == pattern.charAt(1)) {
                res += cnt1;
                cnt2++;
            }
            if (s.charAt(i) == pattern.charAt(0)) {
                cnt1++;
            }
        }
        return res + Math.max(cnt1, cnt2);
    }
}
