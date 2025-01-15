package leetcode;

/**
 * 3095. 或值至少 K 的最短子数组 I
 */
public class Solution3095 {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int value = 0;
            for (int j = i; j < n; j++) {
                value |= nums[j];
                if (value >= k) {
                    res = Math.min(res, j - i + 1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
