package leetcode;

/**
 * 1689. 十-二进制数的最少数目
 */
public class Solution1689 {
    public int minPartitions(String n) {
        int res = 0;
        for (char c : n.toCharArray()) {
            res = Math.max(res, c - '0');
        }
        return res;
    }
}
