package leetcode;

import java.util.Arrays;

/**
 * 2567. 修改两个元素的最小分数
 */
public class Solution2567 {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.min(Math.min(nums[n - 3] - nums[0], nums[n - 2] - nums[1]), nums[n - 1] - nums[2]);
    }
}
