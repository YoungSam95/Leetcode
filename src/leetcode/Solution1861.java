package leetcode;

import java.util.Arrays;

/**
 * 1861. 旋转盒子
 */
public class Solution1861 {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] ans = new char[n][m];
        for (char[] row : ans) {
            Arrays.fill(row, '.');
        }

        for (int i = 0; i < m; i++) {
            char[] row = boxGrid[i];
            int k = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (row[j] == '*') { // 障碍物
                    ans[j][m - 1 - i] = '*';
                    k = j - 1; // 障碍物左边最近的石头，在旋转后掉落到 j-1
                } else if (row[j] == '#') { // 石头
                    ans[k][m - 1 - i] = '#'; // 旋转后，石头掉落到 k
                    k--;
                }
            }
        }

        return ans;
    }
}
