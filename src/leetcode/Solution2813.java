package leetcode;

import java.util.*;

/**
 * 2813. 子序列最大优雅度
 */
public class Solution2813 {
    public long findMaximumElegance(int[][] items, int k) {
        // 把利润从大到小排序
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        long ans = 0;
        long totalProfit = 0;
        Set<Integer> vis = new HashSet<>();
        Deque<Integer> duplicate = new ArrayDeque<>(); // 重复类别的利润
        for (int i = 0; i < items.length; i++) {
            int profit = items[i][0];
            int category = items[i][1];
            if (i < k) {
                totalProfit += profit; // 累加前 k 个项目的利润
                if (!vis.add(category)) { // 重复类别
                    duplicate.push(profit);
                }
            } else if (!duplicate.isEmpty() && vis.add(category)) { // 之前没有的类别
                totalProfit += profit - duplicate.pop(); // 选一个重复类别中的最小利润替换
            } // else：比前面的利润小，而且类别还重复了，选它只会让 totalProfit 变小，vis.size() 不变，优雅度不会变大
            ans = Math.max(ans, totalProfit + (long) vis.size() * vis.size()); // 注意 1e5*1e5 会溢出
        }
        return ans;
    }
}
