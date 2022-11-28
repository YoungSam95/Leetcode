package leetcode;

/**
 * 1758. 生成交替二进制字符串的最少操作数
 * 思路：要么0开头要么1开头，两种情况所需操作数之和为s长度
 */
public class Solution1758 {
    public int minOperations(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != (char) ('0' + i % 2)) {
                cnt++;
            }
        }
        return Math.min(cnt, s.length() - cnt);
    }
}
