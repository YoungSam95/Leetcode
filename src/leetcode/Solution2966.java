package leetcode;

import java.util.Arrays;

/**
 * 2966. 划分数组并满足最大差限制
 */
public class Solution2966 {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] res = new int[n / 3][3];
        for (int i = 0; i < n; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][];
            }
            res[i / 3][0] = nums[i];
            res[i / 3][1] = nums[i + 1];
            res[i / 3][2] = nums[i + 2];
        }
        return res;
    }
}
