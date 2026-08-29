package leetcode;

/**
 * 2091. 从数组中移除最大值和最小值
 */
public class Solution2091 {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        // 找到最小值和最大值的下标
        int minidx = 0, maxidx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minidx]) {
                minidx = i;
            }
            if (nums[i] > nums[maxidx]) {
                maxidx = i;
            }
        }

        int l = Math.min(minidx, maxidx);   // 最值下标中的较小值
        int r = Math.max(minidx, maxidx);   // 最值下标中的较大值

        // 计算三种情况下删除次数的最小值
        return Math.min(Math.min(r + 1, n - l), l + 1 + n - r);
    }
}
