package leetcode;

import java.util.Arrays;

/**
 * 2154. 将找到的值乘以 2
 */
public class Solution2154 {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (original == num) {
                original *= 2;
            }
        }
        return original;
    }
}
