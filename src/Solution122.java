/**
 * 122. 买卖股票的最佳时机 II
 *      可以尽可能地完成更多的交易（多次买卖一支股票）。
 */
public class Solution122 {

    public static int maxProfit(int[] prices) {
        //贪心算法
        /*int max = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - prices[i - 1] > 0){
                max = max + prices[i] - prices[i - 1];
            }
        }
        return max;*/
        //动态规划
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
