package leetcode;

import java.util.Arrays;

/**
 * 2741. 特别的排列
 */
public class Solution2741 {
    static final int MOD = 1000000007;
    int[] nums;
    int n;
    int[][] f;

    public int specialPerm(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.f = new int[1 << n][n];
        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(f[i], -1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + dfs((1 << n) - 1, i)) % MOD;
        }
        return res;
    }

    public int dfs(int state, int i) {
        if (f[state][i] != -1) {
            return f[state][i];
        }
        if (state == (1 << i)) {
            return 1;
        }
        f[state][i] = 0;
        for (int j = 0; j < n; j++) {
            if (i == j || (state >> j & 1) == 0) {
                continue;
            }
            if (nums[i] % nums[j] != 0 && nums[j] % nums[i] != 0) {
                continue;
            }
            f[state][i] = (f[state][i] + dfs(state ^ (1 << i), j)) % MOD;
        }
        return f[state][i];
    }
}
