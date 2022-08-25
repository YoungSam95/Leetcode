package leetcode;

import java.util.Arrays;

/**
 * 1464. 数组中两元素的最大乘积
 */
public class Solution1464 {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }
    public int maxProduct1(int[] nums){
        int a = nums[0], b = nums[1];
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > a) {
                b = a;
                a = nums[i];
            } else if (nums[i] > b) {
                b = nums[i];
            }
        }
        return (a - 1) * (b - 1);
    }
}
