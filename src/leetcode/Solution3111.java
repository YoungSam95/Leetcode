package leetcode;

import java.util.Arrays;

/**
 * 3111. 覆盖所有点的最少矩形数目
 */
public class Solution3111 {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;
        int bound = -1;
        for (int[] p : points) {
            if (p[0] > bound) {
                bound = p[0] + w;
                res++;
            }
        }
        return res;
    }
}
