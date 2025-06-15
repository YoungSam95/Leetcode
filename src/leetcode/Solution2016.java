package leetcode;

/**
 * 2016. 增量元素之间的最大差值
 */
public class Solution2016 {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int ans = -1, premin = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > premin) {
                ans = Math.max(ans, nums[i] - premin);
            } else {
                premin = nums[i];
            }
        }
        return ans;
    }
}
