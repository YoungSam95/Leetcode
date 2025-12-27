package leetcode;

/**
 * 1351. 统计有序矩阵中的负数
 */
public class Solution1351 {
    public int countNegatives(int[][] grid) {
        int num = 0;
        int m = grid[0].length;
        int pos = grid[0].length - 1;

        for (int[] row : grid) {
            int i;
            for (i = pos; i >= 0; i--) {
                if (row[i] >= 0) {
                    if (i + 1 < m) {
                        pos = i + 1;
                        num += m - pos;
                    }
                    break;
                }
            }
            if (i == -1) {
                num += m;
                pos = -1;
            }
        }

        return num;
    }
}
