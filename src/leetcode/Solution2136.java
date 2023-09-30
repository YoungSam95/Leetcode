package leetcode;

import java.util.Arrays;

/**
 * 2136. 全部开花的最早一天
 */
public class Solution2136 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i, j) -> growTime[j] - growTime[i]);
        int ans = 0, t = 0;
        for (int i : idx) {
            t += plantTime[i];
            ans = Math.max(ans, t + growTime[i]);
        }
        return ans;
    }
}
