package leetcode;

/**
 * 3423. 循环数组中相邻元素的最大差值
 */
public class Solution3423 {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int res = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 0; i < n - 1; ++i) {
            res = Math.max(res, Math.abs(nums[i] - nums[i + 1]));
        }
        return res;
    }
}
