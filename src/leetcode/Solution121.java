package leetcode;

/**
 * 121. 买卖股票的最佳时机
 *      给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
 *      你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *      返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 动态规划状态方程：d[i][0] = max{d[i-1][0],d[i-1][1]+prices[i]} 说明：今天没持有，从昨天也没有持有和昨天持有今天卖了两种状态中找最大值
 *               d[i][1] = max{d[i-1][1],d[i-1][0]-prices[i]}  说明：今天持有，从昨天也持有和昨天没持有今天买了两种状态找最大值
 *               因为只能进行一次交易，所以d[i-1][0]=0;
 */
public class Solution121 {

    public static int maxProfit(int[] prices) {
        /*//普通解法，一次遍历
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i : prices){
            if(i < min){
                min = i;
            }else if(i - min > max){
                max = i - min;
            }
        }
        return max;*/
        //动态规划
        int[][] dp= new int[prices.length][2];
        for(int i = 0; i < prices.length; i++){
            if(i == 0){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1],-prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
