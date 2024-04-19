package leetcode;

import java.util.Arrays;

/**
 * 1883. 准时抵达会议现场的最小跳过休息次数
 */
public class Solution1883 {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        long[][] f = new long[n + 1][n + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(f[i], Long.MAX_VALUE / 2);
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j != i) {
                    f[i][j] = Math.min(f[i][j], ((f[i - 1][j] + dist[i - 1] - 1) / speed + 1) * speed);
                }
                if (j != 0) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + dist[i - 1]);
                }
            }
        }
        for (int j = 0; j <= n; ++j) {
            if (f[n][j] <= (long) hoursBefore * speed) {
                return j;
            }
        }
        return -1;
    }
}
