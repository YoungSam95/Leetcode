package leetcode;

/**
 * 3244. 新增道路查询后的最短距离 II
 */
public class Solution3244 {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] roads = new int[n];
        for (int i = 0; i < n; i++) {
            roads[i] = i + 1;
        }
        int[] res = new int[queries.length];
        int dist = n - 1;
        for (int i = 0; i < queries.length; i++) {
            int k = roads[queries[i][0]];
            roads[queries[i][0]] = queries[i][1];
            while (k != -1 && k < queries[i][1]) {
                int t = roads[k];
                roads[k] = -1;
                k = t;
                dist--;
            }
            res[i] = dist;
        }
        return res;
    }
}
