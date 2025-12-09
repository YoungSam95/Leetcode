package leetcode;

/**
 * 3577. 统计计算机解锁顺序排列数
 */
public class Solution3577 {
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }

        int ans = 1;
        int mod = 1000000007;
        for (int i = 2; i < n; i++) {
            ans = (int)((long)ans * i % mod);
        }
        return ans;
    }
}
