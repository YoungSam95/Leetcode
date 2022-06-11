package leetcode;

/**
 * 926. 将字符串翻转到单调递增
 */
public class Solution926 {
    /**
    //前缀和
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int res = n;
        int[] sum = new int[n + 1];
        for(int i = 0; i < n; i++){
            sum[i + 1] = sum[i] + (s.charAt(i) == '0' ? 0 : 1);
        }
        for(int i = 0; i <= n; i++){
            res = Math.min(res,sum[i] + n - i - (sum[n] - sum[i]));
        }
        return res;
    }
     **/
    //动态规划
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];
        dp[0][0] = s.charAt(0) == '0' ? 0 : 1;
        dp[0][1] = s.charAt(0) == '1' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + (s.charAt(i) == '0' ? 0 : 1); // 当前最后一位为0则上一位肯定只能为0
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (s.charAt(i) == '1' ? 0 : 1);
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
