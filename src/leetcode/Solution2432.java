package leetcode;

/**
 * 2432. 处理用时最长的那个任务的员工
 */
public class Solution2432 {
    public int hardestWorker(int n, int[][] logs) {
        int ans = logs[0][0], maxcost = logs[0][1];
        for (int i = 1; i < logs.length; ++i) {
            int idx = logs[i][0];
            int cost = logs[i][1] - logs[i - 1][1];
            if (cost > maxcost || (cost == maxcost && idx < ans)) {
                ans = idx;
                maxcost = cost;
            }
        }
        return ans;
    }
}
