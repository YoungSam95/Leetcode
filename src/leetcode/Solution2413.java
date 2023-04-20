package leetcode;

/**
 * 2413. 最小偶倍数
 */
public class Solution2413 {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : 2 * n;
    }
}
