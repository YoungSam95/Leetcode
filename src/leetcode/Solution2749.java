package leetcode;

/**
 * 2749. 得到整数零需要执行的最少操作数
 */
public class Solution2749 {
    public int makeTheIntegerZero(int num1, int num2) {
        int k = 1;
        while (true) {
            long x = num1 - (long) num2 * k;
            if (x < k) {
                return -1;
            }
            if (k >= Long.bitCount(x)) {
                return k;
            }
            k++;
        }
    }
}
