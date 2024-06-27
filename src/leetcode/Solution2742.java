package leetcode;

import java.util.Arrays;

/**
 * 2742. 给墙壁刷油漆
 */
public class Solution2742 {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[] f = new int[n + 2];
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        f[0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = n + 1; j >= 0; --j) {
                f[Math.min(j + time[i], n) + 1] = Math.min(f[Math.min(j + time[i], n) + 1], f[j] + cost[i]);
            }
        }
        return Math.min(f[n], f[n + 1]);
    }
}
