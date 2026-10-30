package leetcode;

/**
 * 3665. 统计镜子反射路径数目
 */
public class Solution3665 {
    public int uniquePaths(int[][] grid) {
        final int MOD = 1000000007;
        int m = grid.length;
        int n = grid[0].length;

        // f[j][0]：通过向下移动进入当前列
        // f[j][1]：通过向右移动进入当前列
        long[][] f = new long[n][2];
        f[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    if (grid[i - 1][j] == 0) {
                        f[j][0] = (f[j][0] + f[j][1]) % MOD;
                    } else {
                        f[j][0] = f[j][1];
                    }
                }

                if (j > 0) {
                    if (grid[i][j - 1] == 0) {
                        f[j][1] = (f[j - 1][0] + f[j - 1][1]) % MOD;
                    } else {
                        f[j][1] = f[j - 1][0];
                    }
                }
            }
        }

        return (int)((f[n - 1][0] + f[n - 1][1]) % MOD);
    }
}
