package leetcode;

/**
 * 3370. 仅含置位位的最小整数
 */
public class Solution3370 {
    public int smallestNumber(int n) {
        int x = 1;
        while (x < n) {
            x = x * 2 + 1;
        }
        return x;
    }
}
