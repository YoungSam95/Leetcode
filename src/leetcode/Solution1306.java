package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1306. 跳跃游戏 III
 */
public class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }

        int n = arr.length;
        boolean[] used = new boolean[n];
        used[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : new int[]{u + arr[u], u - arr[u]}) {
                if (0 <= v && v < n && !used[v]) {
                    if (arr[v] == 0) {
                        return true;
                    }
                    q.offer(v);
                    used[v] = true;
                }
            }
        }

        return false;
    }
}
