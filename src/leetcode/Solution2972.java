package leetcode;

/**
 * 2972. 统计移除递增子数组的数目 II
 */
public class Solution2972 {
    public long incremovableSubarrayCount(int[] nums) {
        long ans = 0;
        int len = nums.length;
        int l = 0;
        while (l < len - 1) {
            if (nums[l] >= nums[l + 1]) {
                break;
            }
            l++;
        }
        if (l == len - 1) {
            return 1L * len * (len + 1) / 2;
        }

        ans += l + 2;
        for (int r = len - 1; r > 0; r--) {
            if (r < len - 1 && nums[r] >= nums[r + 1]) {
                break;
            }

            while (l >= 0 && nums[l] >= nums[r]) {
                l--;
            }
            ans += l + 2;
        }

        return ans;
    }
}
