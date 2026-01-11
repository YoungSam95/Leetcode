package leetcode;

/**
 * 1266. 访问所有点的最小时间
 */
public class Solution1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int x0 = points[0][0], y0 = points[0][1];
        int ans = 0;
        for (int i = 1; i < points.length; ++i) {
            int x1 = points[i][0], y1 = points[i][1];
            ans += Math.max(Math.abs(x0 - x1), Math.abs(y0 - y1));
            x0 = x1;
            y0 = y1;
        }
        return ans;
    }
}
