package leetcode;

/**
 * 2683. 相邻值的按位异或
 */
public class Solution2683 {
    public boolean doesValidArrayExist(int[] derived) {
        int xor = 0;
        for (int x : derived) {
            xor ^= x;
        }
        return xor == 0;
    }
}
