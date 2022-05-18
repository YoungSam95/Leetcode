package leetcode;

import java.util.Arrays;

/**
 * 462. 最少移动次数使数组元素相等 II
 * 思路：找中位数
 */
public class Solution462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int res = 0;
        for(int num : nums){
            res += Math.abs(num - mid);
        }
        return res;
    }
}
