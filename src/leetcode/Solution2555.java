package leetcode;

/**
 * 2555. 两个线段获得的最多奖品
 */
public class Solution2555 {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int[] dp = new int[n + 1];
        int ans = 0;
        for (int left = 0, right = 0; right < n; right++) {
            while (prizePositions[right] - prizePositions[left] > k) {
                left++;
            }
            ans = Math.max(ans, right - left + 1 + dp[left]);
            dp[right + 1] = Math.max(dp[right], right - left + 1);
        }
        return ans;
    }
}
