package leetcode;

import java.util.HashMap;

/**
 * 3117. 划分数组得到最小的值之和
 */
public class Solution3117 {
    private static final int INF = (1 << 20) - 1;
    private HashMap<Integer, Integer>[] memo;

    public int minimumValueSum(int[] nums, int[] andValues) {
        int n = nums.length, m = andValues.length;
        memo = new HashMap[m * n];
        for (int i = 0; i < m * n; ++i) {
            memo[i] = new HashMap<Integer, Integer>();
        }
        int res = dfs(0, 0, INF, nums, andValues);
        return res < INF ? res : -1;
    }

    private int dfs(int i, int j, int cur, int[] nums, int[] andValues) {
        int n = nums.length, m = andValues.length, key = i * m + j;
        if (i == nums.length && j == andValues.length) {
            return 0;
        }
        if (i == nums.length || j == andValues.length) {
            return INF;
        }
        if (memo[key].containsKey(cur)) {
            return memo[key].get(cur);
        }
        cur &= nums[i];
        if ((cur & andValues[j]) < andValues[j]) {
            return INF;
        }
        int res = dfs(i + 1, j, cur, nums, andValues);
        if (cur == andValues[j]) {
            res = Math.min(res, dfs(i + 1, j + 1, INF, nums, andValues) + nums[i]);
        }
        memo[key].put(cur, res);
        return res;
    }
}
