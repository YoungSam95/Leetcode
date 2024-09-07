package leetcode;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 */
public class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}
