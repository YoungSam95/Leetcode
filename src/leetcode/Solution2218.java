package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 2218. 从栈中取出 K 个硬币的最大面值和
 */
public class Solution2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] f = new int[k + 1];
        Arrays.fill(f, -1);
        f[0] = 0;
        for (List<Integer> pile : piles) {
            for (int i = k; i > 0; --i) {
                int value = 0;
                for (int t = 1; t <= pile.size(); ++t) {
                    value += pile.get(t - 1);
                    if (i >= t && f[i - t] != -1) {
                        f[i] = Math.max(f[i], f[i - t] + value);
                    }
                }
            }
        }
        return f[k];
    }
}
