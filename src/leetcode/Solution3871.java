package leetcode;

/**
 * 3871. 统计范围内的逗号 II
 */
public class Solution3871 {
    public long countCommas(long n) {
        long p = 1000, res = 0;
        while (p <= n) {
            res += n - p + 1;
            p *= 1000;
        }
        return res;
    }
}
