package leetcode;

import java.util.Arrays;

/**
 * 322.零钱兑换
 */

class Solution322 {

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            for(int coin : coins){
                if(i - coin < 0) continue;
                dp[i] = Math.min(dp[i],dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args){

        int[] coins = {1,2,5};
        int amount = 10;
        System.out.println(coinChange(coins,amount));
    }
}