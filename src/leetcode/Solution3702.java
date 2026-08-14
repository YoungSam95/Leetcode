package leetcode;

/**
 * 3702. 按位异或非零的最长子序列
 */
public class Solution3702 {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalXor = 0;
        boolean allZero = true;

        for (int x : nums) {
            totalXor ^= x;
            if (x > 0) {
                allZero = false;
            }
        }
        if (totalXor > 0) {
            return n;
        }

        return allZero ? 0 : n - 1;
    }
}
