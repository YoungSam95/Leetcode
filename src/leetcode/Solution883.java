package leetcode;

/**
 * 883.三维形体投影面积
 * 思路：xy 平面的投影面积等于网格上非零数值的数目；
 *      yz 平面的投影面积等于网格上每一列最大数值之和；
 *      zx 平面的投影面积等于网格上每一行最大数值之和。
 */
public class Solution883 {

    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyArea = 0, yzArea = 0, zxArea = 0;
        for (int i = 0; i < n; i++) {
            int yzHeight = 0, zxHeight = 0;
            for (int j = 0; j < n; j++) {
                xyArea += grid[i][j] > 0 ? 1 : 0;
                yzHeight = Math.max(yzHeight, grid[j][i]);
                zxHeight = Math.max(zxHeight, grid[i][j]);
            }
            yzArea += yzHeight;
            zxArea += zxHeight;
        }
        return xyArea + yzArea + zxArea;
    }
}
