package leetcode;

/**
 * 2481. 分割圆的最少切割次数
 */
public class Solution2481 {
    public int numberOfCuts(int n) {
        return n == 1 ? 0 : (n % 2 ==0 ? n / 2 : n);
    }
}
