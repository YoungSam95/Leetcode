package leetcode;

/**
 * 2712. 使所有字符相等的最小成本
 */
public class Solution2712 {
    public long minimumCost(String s) {
        int n = s.length();
        long res = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                res += Math.min(i, n - i);
            }
        }
        return res;
    }
}
