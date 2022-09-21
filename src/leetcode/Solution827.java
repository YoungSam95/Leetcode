package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 827. 最大人工岛
 */
public class Solution827 {
    static int[] d = {0, -1, 0, 1, 0};//上下左右四个方向

    public int largestIsland(int[][] grid) {
        int n = grid.length, res = 0;
        int[][] tag = new int[n][n];//为岛屿做标记
        Map<Integer, Integer> area = new HashMap<>();//记录岛屿面积
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && tag[i][j] == 0) {//如果是陆地并且还没划分到某个岛屿
                    int t = i * n + j + 1;//岛屿编号
                    area.put(t, dfs(grid, i, j, tag, t));//深度搜多t编号岛屿的面积
                    res = Math.max(res, area.get(t));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int z = 1;//将当前海变成陆地，面积即为1
                    Set<Integer> connected = new HashSet<>();//用于排除重复的岛屿
                    for (int k = 0; k < 4; k++) {//向上下左右四个方向搜索
                        int x = i + d[k], y = j + d[k + 1];
                        if (!valid(n, x, y) || tag[x][y] == 0 || connected.contains(tag[x][y])) {
                            continue;//超出边界或者不属于岛屿或者是搜索过的岛屿，跳过
                        }
                        z += area.get(tag[x][y]);//面积增加
                        connected.add(tag[x][y]);//记录
                    }
                    res = Math.max(res, z);
                }
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int x, int y, int[][] tag, int t) {
        int n = grid.length, res = 1;
        tag[x][y] = t;
        for (int i = 0; i < 4; i++) {
            int x1 = x + d[i], y1 = y + d[i + 1];
            if (valid(n, x1, y1) && grid[x1][y1] == 1 && tag[x1][y1] == 0) {
                res += dfs(grid, x1, y1, tag, t);
            }
        }
        return res;
    }

    public boolean valid(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
