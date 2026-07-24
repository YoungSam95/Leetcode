package leetcode;

/**
 * 3536. 两个数字的最大乘积
 */
public class Solution3536 {
    public int maxProduct(int n) {
        int first = 0, second = 0;
        while (n > 0) {
            int x = n % 10;
            if (x > first) {
                second = first;
                first = x;
            } else if (x > second) {
                second = x;
            }
            n /= 10;
        }
        return first * second;
    }
}
