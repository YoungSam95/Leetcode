package leetcode;

/**
 * 2485. 找出中枢整数
 */
public class Solution2485 {
    public int pivotInteger(int n) {
        int t = (n * n + n) / 2;
        int x = (int) Math.sqrt(t);
        if (x * x == t) {
            return x;
        }
        return -1;
    }
}
