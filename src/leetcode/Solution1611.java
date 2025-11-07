package leetcode;

/**
 * 1611. 使整数变为 0 的最少操作次数
 */
public class Solution1611 {
    public int minimumOneBitOperations(int n) {
        int ans = 0;
        while (n != 0) {
            ans ^= n;
            n >>= 1;
        }
        return ans;
    }
}
