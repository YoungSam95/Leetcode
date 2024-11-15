package leetcode;

import java.util.Arrays;

/**
 * 3240. 最少翻转次数使二进制矩阵回文 II
 */
public class Solution3240 {
    public int minFlips(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] f = new int[4];
        Arrays.fill(f, Integer.MAX_VALUE / 2);
        f[0] = 0;

        for (int i = 0; i < (m + 1) / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int ones = grid[i][j], cnt = 1;
                if (j != n - 1 - j) {
                    ones += grid[i][n - 1 - j];
                    cnt++;
                }
                if (i != m - 1 - i) {
                    ones += grid[m - 1 - i][j];
                    cnt++;
                }
                if (i != m - 1 - i && j != n - 1 - j) {
                    ones += grid[m - 1 - i][n - 1 - j];
                    cnt++;
                }
                // 计算将这一组全部变为 1 的代价
                int cnt1 = cnt - ones;
                // 计算将这一组全部变为 0 的代价
                int cnt0 = ones;
                int[] tmp = new int[4];
                for (int k = 0; k < 4; k++) {
                    tmp[k] = f[k] + cnt0;
                }
                for (int k = 0; k < 4; k++) {
                    tmp[(k + cnt) % 4] = Math.min(tmp[(k + cnt) % 4], f[k] + cnt1);
                }
                f = tmp;
            }
        }
        return f[0];
    }
}
