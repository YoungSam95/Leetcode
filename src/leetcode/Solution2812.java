package leetcode;

import java.util.*;

/**
 * 2812. 找出最安全路径
 */
public class Solution2812 {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] dis = new int[n][n];
        for (int[] row : dis) Arrays.fill(row, -1);
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                    dis[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];
            for (int[] d : dirs) {
                int nx = cx + d[0];
                int ny = cy + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && dis[nx][ny] == -1) {
                    dis[nx][ny] = dis[cx][cy] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        boolean[][] visit = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        visit[0][0] = true;
        pq.offer(new int[]{dis[0][0], 0, 0});
        int maxSafenessFactor = Math.min(dis[0][0], dis[n - 1][n - 1]);

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int val = cur[0], cx = cur[1], cy = cur[2];
            maxSafenessFactor = Math.min(maxSafenessFactor, val);
            if (cx == n - 1 && cy == n - 1) {
                break;
            }
            for (int[] d : dirs) {
                int nx = cx + d[0];
                int ny = cy + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    pq.offer(new int[]{dis[nx][ny], nx, ny});
                }
            }
        }
        return maxSafenessFactor;
    }
}
