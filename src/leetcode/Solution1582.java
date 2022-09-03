package leetcode;

/**
 * 1582. 二进制矩阵中的特殊位置
 */
public class Solution1582 {
    public int numSpecial(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[] rowsSum = new int[row];
        int[] colsSum = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rowsSum[i] += mat[i][j];
                colsSum[j] += mat[i][j];
            }
        }
        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 1 && rowsSum[i] == 1 && colsSum[j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
