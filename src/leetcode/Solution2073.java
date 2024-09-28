package leetcode;

/**
 * 2073. 买票需要的时间
 */
public class Solution2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 遍历计算每个人所需时间
            if (i <= k) {
                res += Math.min(tickets[i], tickets[k]);
            } else {
                res += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return res;
    }
}
