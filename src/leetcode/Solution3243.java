package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 3243. 新增道路查询后的最短距离 I
 */
public class Solution3243 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> prev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prev.add(new ArrayList<>());
        }
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            prev.get(i).add(i - 1);
            dp[i] = i;
        }
        int [] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            prev.get(queries[i][1]).add(queries[i][0]);
            for (int v = queries[i][1]; v < n; v++) {
                for (int u : prev.get(v)) {
                    dp[v] = Math.min(dp[v], dp[u] + 1);
                }
            }
            res[i] = dp[n - 1];
        }
        return res;
    }
}
