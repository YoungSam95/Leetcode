package leetcode;

/**
 * 1922. 统计好数字的数目
 */
public class Solution1922 {
    long mod = 1000000007;

    public int countGoodNumbers(long n) {
        return (int) (quickmul(5, (n + 1) / 2) * quickmul(4, n / 2) % mod);
    }

    // 快速幂求出 x^y % mod
    public long quickmul(int x, long y) {
        long ret = 1;
        long mul = x;
        while (y > 0) {
            if (y % 2 == 1) {
                ret = ret * mul % mod;
            }
            mul = mul * mul % mod;
            y /= 2;
        }

        return ret;
    }
}
