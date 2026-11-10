package leetcode;

/**
 * 3789. 采购的最小花费
 */
public class Solution3789 {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long totalCost = 0;

        // 分别购买更便宜，不需要物品 3
        if (cost1 + cost2 <= costBoth) {
            totalCost = 1L * cost1 * need1 + 1L * cost2 * need2;
        } else {
            // 优先购买物品 3，直到一种需求满足
            int cnt_3 = Math.min(need1, need2);
            totalCost = 1L * cnt_3 * costBoth;

            need1 -= cnt_3;
            need2 -= cnt_3;

            // 类型 1 的需求还未被满足，选择物品 1 或物品 3 中更便宜的
            if (need1 > 0) {
                totalCost += 1L * need1 * Math.min(cost1, costBoth);
                // 类型 2 的需求还未被满足，选择物品 2 或物品 3 中更便宜的
            } else if (need2 > 0) {
                totalCost += 1L * need2 * Math.min(cost2, costBoth);
            }
        }

        return totalCost;
    }
}
