package leetcode;

/**
 * 3233. 统计不是特殊数字的数字数量
 */
public class Solution3233 {
    public int nonSpecialCount(int l, int r) {
        int n = (int) Math.sqrt(r);
        int[] v = new int[n + 1];
        int res = r - l + 1;
        for (int i = 2; i <= n; i++) {
            if (v[i] == 0) {
                if (i * i >= l && i * i <= r) {
                    res--;
                }
                for (int j = i * 2; j <= n; j += i) {
                    v[j] = 1;
                }
            }
        }
        return res;
    }

}
