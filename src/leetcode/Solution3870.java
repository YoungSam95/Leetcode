package leetcode;

/**
 * 3870. 统计范围内的逗号
 */
public class Solution3870 {
    public int countCommas(int n) {
        int res = 0;
        for (int a = 1; a <= n; ++a) {
            if (a > 999) {
                res += 1;
            }
        }
        return res;
    }
}
