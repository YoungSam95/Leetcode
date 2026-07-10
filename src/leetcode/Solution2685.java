package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 2685. 统计完全连通分量的数量
 */
public class Solution2685 {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int V = 0, E = 0;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int u = queue.poll();
                    V++;
                    E += graph.get(u).size();
                    for (int v : graph.get(u)) {
                        if (!visited[v]) {
                            visited[v] = true;
                            queue.offer(v);
                        }
                    }
                }
                if (E == V * (V - 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
