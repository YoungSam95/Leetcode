package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1091. 二进制矩阵中的最短路径
 */
public class Solution1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }

        Queue<int[]> q = new LinkedList<>();
        // 需要记录走过的路径，避免死循环
        boolean[][] visited = new boolean[m][n];

        // 初始化队列，从 (0, 0) 出发
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        int pathLen = 1;

        // 执行 BFS 算法框架，从值为 0 的坐标开始向八个方向扩散
        int[][] dirs = new int[][]{
                {0, 1}, {0, -1}, {1, 0}, {-1, 0},
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int __ = 0; __ < sz; __++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                if (x == m - 1 && y == n - 1) {
                    return pathLen;
                }
                // 向八个方向扩散
                for (int i = 0; i < 8; i++) {
                    int nextX = x + dirs[i][0];
                    int nextY = y + dirs[i][1];
                    // 确保相邻的这个坐标没有越界且值为 0 且之前没有走过
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n
                            && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                        q.offer(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
            pathLen++;
        }
        return -1;
    }
}
