package leetcode;

import java.util.Arrays;

/**
 * 3176. 求出最长好子序列 I
 */
public class Solution3176 {
    public int maximumLength(int[] nums, int k) {
        int ans = 0;
        int len = nums.length;
        int[][] dp = new int[len][51];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < len; i++) {
            dp[i][0] = 1;
            for (int l = 0; l <= k; l++) {
                for (int j = 0; j < i; j++) {
                    int add = nums[i] != nums[j] ? 1 : 0;
                    if (l - add >= 0 && dp[j][l - add] != -1) {
                        dp[i][l] = Math.max(dp[i][l], dp[j][l - add] + 1);
                    }
                }
                ans = Math.max(ans, dp[i][l]);
            }
        }

        return ans;
    }
}
