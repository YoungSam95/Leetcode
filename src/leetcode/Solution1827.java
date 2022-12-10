package leetcode;

/**
 * 1827. 最少操作使数组递增
 */
public class Solution1827 {
    public int minOperations(int[] nums) {
        int step = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] <= nums[i - 1]){
                step += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }
        return step;
    }
}
