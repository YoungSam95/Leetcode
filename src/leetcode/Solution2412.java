package leetcode;

/**
 * 2412. 完成所有交易的初始最少钱数
 */
public class Solution2412 {
    public long minimumMoney(int[][] transactions) {
        long totalLose = 0;
        int res = 0;
        for (int[] t : transactions) {
            int cost = t[0];
            int cashback = t[1];
            totalLose += Math.max(cost - cashback, 0);
            res = Math.max(res, Math.min(cost, cashback));
        }
        return totalLose + res;
    }
}
