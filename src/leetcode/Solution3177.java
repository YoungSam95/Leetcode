package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3177. 求出最长好子序列 II
 */
public class Solution3177 {
    public int maximumLength(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, int[]> dp = new HashMap<Integer, int[]>();
        int[] zd = new int[k + 1];

        for (int i = 0; i < len; i++) {
            int v = nums[i];
            dp.putIfAbsent(v, new int[k + 1]);

            int[] tmp = dp.get(v);
            for (int j = 0; j <= k; j++) {
                tmp[j] = tmp[j] + 1;
                if (j > 0) {
                    tmp[j] = Math.max(tmp[j], zd[j - 1] + 1);
                }
            }
            for (int j = 0; j <= k; j++) {
                zd[j] = Math.max(zd[j], tmp[j]);
            }
        }
        return zd[k];
    }
}
