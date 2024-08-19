package leetcode;

/**
 * 3154. 到达第 K 级台阶的方案数
 */
public class Solution3154 {
    public int waysToReachStair(int k) {
        int n = 0, npow = 1, ans = 0;
        while (true) {
            if (npow - n - 1 <= k && k <= npow) {
                ans += comb(n + 1, npow - k);
            } else if (npow - n - 1 > k) {
                break;
            }
            ++n;
            npow *= 2;
        }
        return ans;
    }

    public int comb(int n, int k) {
        long ans = 1;
        for (int i = n; i >= n - k + 1; --i) {
            ans *= i;
            ans /= n - i + 1;
        }
        return (int) ans;
    }
}
