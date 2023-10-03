package leetcode;

/**
 * 123. 买卖股票的最佳时机 III  最多可以买2次，买之前必须先把买过的卖掉
 * 第二次
 */
public class Solution123 {

    public static int maxProfit(int[] prices) {
        /**
         * 对于第i天，有五种状态：                        对应的状态转移方程：
         *                    1.不操作，对应本身
         *                    2.第一次买，buy1         buy1 = max{buy1,-prices[i]}
         *                    3.完成第一次交易，sell1   sell1 = max{sell1,buy1 + prices[i]}
         *                    4.第二次买，buy2         buy2 = max{buy2,sell1 - prices[i]}
         *                    5.完成第二次交易，sell2   sell2 = max{sell2,buy2 + prices[i]}
         * 在动态规划结束后，由于我们可以进行不超过两笔交易，因此最终的答案在0、sell1和sell2中，且为三者中的最大值。然而我们可以发现，由于在边界条件中
         * sell1和sell2的值已经为 0，并且在状态转移的过程中我们维护的是最大值，因此 sell1和sell2 最终一定大于等于 00。同时，如果最优的情况对应的是
         * 恰好一笔交易，那么它也会因为我们在转移时允许在同一天买入并且卖出这一宽松的条件，从sell1转移至sell2 ，因此最终的答案即为sell2
         */
        /*int buy1 = -prices[0],sell1 = 0,buy2 = -prices[0],sell2 =0;
        for(int i = 1; i < prices.length; i++){
            buy1 = Math.max(buy1,-prices[i]);
            sell1 = Math.max(sell1,buy1 + prices[i]);
            buy2 = Math.max(buy2,sell1 - prices[i]);
            sell2 = Math.max(sell2,buy2 + prices[i]);
        }
        return sell2;*/

        int max_k = 2, n = prices.length;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    // 处理 base case
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        }
        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0];

        /*// k取值范围比较小，所以可以不用 for 循环，直接把 k = 1 和 2 的情况全部列举出来也可以：
        //与官房解法殊途同归
        // 状态转移方程：
        // dp[i][2][0] = max(dp[i-1][2][0], dp[i-1][2][1] + prices[i])
        // dp[i][2][1] = max(dp[i-1][2][1], dp[i-1][1][0] - prices[i])
        // dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
        // dp[i][1][1] = max(dp[i-1][1][1], -prices[i])
        // base case
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;*/

    }

    public static void main(String[] args){
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));
    }
}
