package leetcode;

import java.util.Arrays;

/**
 * 3194. 最小元素和最大元素的最小平均值
 */
public class Solution3194 {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        double res = Double.MAX_VALUE;
        for (int i = 0; i < n / 2; i++) {
            res = Math.min(res, (nums[i] + nums[n - 1 - i]) / 2.0);
        }
        return res;
    }
}
