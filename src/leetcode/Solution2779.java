package leetcode;

import java.util.Arrays;

/**
 * 2779. 数组的最大美丽值
 */
public class Solution2779 {
    public int maximumBeauty(int[] nums, int k) {
        int res = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = 0, j = 0; i < n; i++) {
            while (nums[i] - 2 * k > nums[j]) {
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
