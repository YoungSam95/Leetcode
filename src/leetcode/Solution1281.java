package leetcode;

/**
 * 1281. 整数的各位积和之差
 */
public class Solution1281 {
    public int subtractProductAndSum(int n) {
        int m = 1, s = 0;
        while (n != 0) {
            int x = n % 10;
            n /= 10;
            m *= x;
            s += x;
        }
        return m - s;
    }
}
