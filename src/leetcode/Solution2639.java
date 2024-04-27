package leetcode;

/**
 * 2639. 查询网格图中每一列的宽度
 */
public class Solution2639 {
    public int[] findColumnWidth(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] res = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[j] = Math.max(res[j], String.valueOf(grid[i][j]).length());
            }
        }
        return res;
    }
}
