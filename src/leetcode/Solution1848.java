package leetcode;

/**
 * 1848. 到目标元素的最小距离
 */
public class Solution1848 {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int res = n;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == target) {
                res = Math.min(res, Math.abs(i - start));
            }
        }
        return res;
    }
}
