package leetcode;

/**
 * 2643. 一最多的行
 */
public class Solution2643 {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxOnes = 0;
        int rowIndex = 0;
        for (int i = 0; i < mat.length; i++) {
            int tot = 0;
            for (int j = 0; j < mat[i].length; j++) {
                tot += mat[i][j];
            }
            if (tot > maxOnes) {
                maxOnes = tot;
                rowIndex = i;
            }
        }
        return new int[]{rowIndex, maxOnes};
    }
}
