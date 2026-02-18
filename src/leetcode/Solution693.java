package leetcode;

/**
 * 693. 交替位二进制数
 */
public class Solution693 {
    public boolean hasAlternatingBits(int n) {
        int a = n ^ (n >> 1);
        return (a & (a + 1)) == 0;
    }
}
