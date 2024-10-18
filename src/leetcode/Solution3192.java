package leetcode;

/**
 * 3192. 使二进制数组全部等于 1 的最少操作次数 II
 */
public class Solution3192 {
    public int minOperations(int[] nums) {
        int operation = 0;
        for (int num : nums) {
            if (num == (operation % 2)) {
                operation++;
            }
        }
        return operation;
    }
}
