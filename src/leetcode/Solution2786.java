package leetcode;

/**
 * 2786. 访问数组中的位置使分数最大
 */
public class Solution2786 {
    public long maxScore(int[] nums, int x) {
        long res = nums[0];
        long[] dp = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        dp[nums[0] % 2] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int parity = (int) (nums[i] % 2);
            long cur = Math.max(dp[parity] + nums[i], dp[1 - parity] - x + nums[i]);
            res = Math.max(res, cur);
            dp[parity] = Math.max(dp[parity], cur);
        }
        return res;
    }
}
