package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1329. 将矩阵按对角线排序
 */
public class Solution1329 {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] a = new int[Math.min(m, n)];
        for (int k = 1 - n; k < m; k++) { // k = i - j
            int leftI = Math.max(k, 0);
            int rightI = Math.min(k + n, m);
            for (int i = leftI; i < rightI; i++) {
                a[i - leftI] = mat[i][i - k];
            }
            Arrays.sort(a, 0, rightI - leftI);
            for (int i = leftI; i < rightI; i++) {
                mat[i][i - k] = a[i - leftI];
            }
        }
        return mat;
    }
}
