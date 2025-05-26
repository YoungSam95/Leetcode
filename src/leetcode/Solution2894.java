package leetcode;

/**
 * 2894. 分类求和并作差
 */
public class Solution2894 {
    public int differenceOfSums(int n, int m) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                ans -= i;
            } else {
                ans += i;
            }
        }
        return ans;
    }

}
