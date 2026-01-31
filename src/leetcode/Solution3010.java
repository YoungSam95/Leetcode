package leetcode;

import java.util.Arrays;

/**
 * 3010. 将数组分成最小总代价的子数组 I
 */
public class Solution3010 {
    public int minimumCost(int[] nums) {
        Arrays.sort(nums, 1, nums.length);
        return nums[0] + nums[1] + nums[2];
    }
}
