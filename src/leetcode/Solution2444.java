package leetcode;

/**
 * 2444. 统计定界子数组的数目
 */
public class Solution2444 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int border = -1, last_min = -1, last_max = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                last_max = -1;
                last_min = -1;
                border = i;
            }
            if (nums[i] == minK) {
                last_min = i;
            }
            if (nums[i] == maxK) {
                last_max = i;
            }
            if (last_min != -1 && last_max != -1) {
                res += Math.min(last_min, last_max) - border;
            }
        }
        return res;
    }
}
