package leetcode;

/**
 * 2645. 构造有效字符串的最少插入数
 */
public class Solution2645 {
    public int addMinimum(String word) {
        int n = word.length();
        int res = word.charAt(0) - word.charAt(n - 1) + 2;
        for (int i = 1; i < n; i++) {
            res += (word.charAt(i) - word.charAt(i - 1) + 2) % 3;
        }
        return res;
    }
}
