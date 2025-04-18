package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2711. 对角线上不同值的数量差
 */
public class Solution2711 {
    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; ++i) {
            int x = i, y = 0;
            Set<Integer> s = new HashSet<>();
            while (x < m && y < n) {
                res[x][y] += s.size();
                s.add(grid[x][y]);
                x += 1;
                y += 1;
            }
        }

        for (int j = 1; j < n; ++j) {
            int x = 0, y = j;
            Set<Integer> s = new HashSet<>();
            while (x < m && y < n) {
                res[x][y] += s.size();
                s.add(grid[x][y]);
                x += 1;
                y += 1;
            }
        }

        for (int i = 0; i < m; ++i) {
            int x = i, y = n - 1;
            Set<Integer> s = new HashSet<>();
            while (x >= 0 && y >= 0) {
                res[x][y] -= s.size();
                res[x][y] = Math.abs(res[x][y]);
                s.add(grid[x][y]);
                x -= 1;
                y -= 1;
            }
        }

        for (int j = n - 2; j >= 0; --j) {
            int x = m - 1, y = j;
            Set<Integer> s = new HashSet<>();
            while (x >= 0 && y >= 0) {
                res[x][y] -= s.size();
                res[x][y] = Math.abs(res[x][y]);
                s.add(grid[x][y]);
                x -= 1;
                y -= 1;
            }
        }

        return res;
    }
}
