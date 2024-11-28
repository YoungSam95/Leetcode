package leetcode;

/**
 * 3251. 单调数组对的数目 II
 */
public class Solution3251 {
    public int countOfPairs(int[] nums) {
        int n = nums.length, m = 0, mod = 1000000007;
        for (int num : nums) {
            m = Math.max(m, num);
        }
        int[][] dp = new int[n][m + 1];
        for (int a = 0; a <= nums[0]; a++) {
            dp[0][a] = 1;
        }
        for (int i = 1; i < n; i++) {
            int d = Math.max(0, nums[i] - nums[i - 1]);
            for (int j = d; j <= nums[i]; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j - d];
                } else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - d]) % mod;
                }
            }
        }
        int res = 0;
        for (int num : dp[n - 1]) {
            res = (res + num) % mod;
        }
        return res;
    }
}
