package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3098. 求出所有子序列的能量和
 */
public class Solution3098 {
    static final int MOD = 1000000007, INF = 0x3f3f3f3f;

    public int sumOfPowers(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        Map<Integer, Integer>[][] d = new Map[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                d[i][j] = new HashMap<Integer, Integer>();
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            d[i][1].put(INF, 1);
            for (int j = 0; j < i; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                for (int p = 2; p <= k; p++) {
                    for (Map.Entry<Integer, Integer> entry : d[j][p - 1].entrySet()) {
                        int v = entry.getKey(), cnt = entry.getValue();
                        int currKey = Math.min(diff, v);
                        d[i][p].put(currKey, (d[i][p].getOrDefault(currKey, 0) + cnt) % MOD);
                    }
                }
            }

            for (Map.Entry<Integer, Integer> entry : d[i][k].entrySet()) {
                int v = entry.getKey(), cnt = entry.getValue();
                res = (int) ((res + 1L * v * cnt % MOD) % MOD);
            }
        }
        return res;
    }
}
