package leetcode;

import java.util.Arrays;

/**
 * 2784. 检查数组是否是好的
 */
public class Solution2784 {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }
        return nums[n] == n;
    }
}
