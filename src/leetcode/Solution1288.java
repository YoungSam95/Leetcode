package leetcode;

import java.util.Arrays;

/**
 * 1288. 删除被覆盖区间
 */
public class Solution1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (u, v) -> {
            if (u[0] != v[0]) {
                return u[0] - v[0];
            }
            return v[1] - u[1];
        });
        int ans = n;
        int rmax = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][1] <= rmax) {
                ans--;
            } else {
                rmax = Math.max(rmax, intervals[i][1]);
            }
        }
        return ans;
    }
}
