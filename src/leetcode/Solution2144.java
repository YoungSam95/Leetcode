package leetcode;

import java.util.Arrays;

/**
 * 2144. 打折购买糖果的最小开销
 */
public class Solution2144 {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res = 0;
        int n = cost.length;
        for (int i = n - 1; i >= 0; --i) {
            if ((n - 1 - i) % 3 != 2) {
                res += cost[i];
            }
        }
        return res;
    }
}
