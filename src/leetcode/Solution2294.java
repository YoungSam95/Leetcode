package leetcode;

import java.util.Arrays;

/**
 * 2294. 划分数组使最大差为 K
 */
public class Solution2294 {
    public int partitionArray(int[] nums, int k) {
        int count = 1;
        Arrays.sort(nums);
        int start = nums[0];
        for (int num : nums) {
            if (num - start > k) {
                count++;
                start = num;
            }
        }
        return count;
    }
}
