package leetcode;

import java.util.List;

/**
 * 3349. 检测相邻递增子数组 I
 */
public class Solution3349 {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i = 0; i + 2 * k <= n; i++) {
            if (isIncreasingSubarray(nums, i, i + k - 1) && isIncreasingSubarray(nums, i + k, i + 2 * k - 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean isIncreasingSubarray(List<Integer> nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
