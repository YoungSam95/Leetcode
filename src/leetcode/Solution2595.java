package leetcode;

/**
 * 2595. 奇偶位数
 */
public class Solution2595 {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        int i = 0;
        while (n > 0) {
            res[i] += n & 1;
            n >>= 1;
            i ^= 1;
        }
        return res;
    }
}
