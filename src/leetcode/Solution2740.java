package leetcode;

import java.util.Arrays;

/**
 * 2740. 找出分区值
 */
public class Solution2740 {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            res = Math.min(res, nums[i] - nums[i - 1]);
        }
        return res;
    }
}
