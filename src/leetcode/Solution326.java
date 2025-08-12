package leetcode;

/**
 * 326. 3 的幂
 */
public class Solution326 {
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
