package leetcode;

import java.util.Arrays;

/**
 * 3143. 正方形中的最多点数
 */
public class Solution3143 {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int[] min1 = new int[26];
        Arrays.fill(min1, 1000000001);
        int min2 = 1000000001, n = s.length();
        for (int i = 0; i < n; ++i) {
            int x = points[i][0], y = points[i][1], j = s.charAt(i) - 'a';
            int d = Math.max(Math.abs(x), Math.abs(y));
            if (d < min1[j]) {
                min2 = Math.min(min2, min1[j]);
                min1[j] = d;
            } else if (d < min2) {
                min2 = d;
            }
        }
        int res = 0;
        for (int d : min1) {
            if (d < min2) {
                ++res;
            }
        }
        return res;
    }
}
