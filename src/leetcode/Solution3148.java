package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 3148. 矩阵中的最大得分
 */
public class Solution3148 {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        int[] precol = new int[n];
        Arrays.fill(precol, Integer.MIN_VALUE);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; ++i) {
            int prerow = Integer.MIN_VALUE;
            for (int j = 0; j < n; ++j) {
                int f = Integer.MIN_VALUE;
                if (i > 0) {
                    f = Math.max(f, grid.get(i).get(j) + precol[j]);
                }
                if (j > 0) {
                    f = Math.max(f, grid.get(i).get(j) + prerow);
                }
                ans = Math.max(ans, f);
                precol[j] = Math.max(precol[j], Math.max(f, 0) - grid.get(i).get(j));
                prerow = Math.max(prerow, Math.max(f, 0) - grid.get(i).get(j));
            }
        }
        return ans;
    }
}
