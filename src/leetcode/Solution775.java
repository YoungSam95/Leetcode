package leetcode;

/**
 * 775. 全局倒置与局部倒置
 */
public class Solution775 {
    public boolean isIdealPermutation(int[] nums) {
        // 满足局部倒置的就一定满足全局倒置
        // 所以排除局部倒置的情况，只要存在一个全局倒置就返回false
        int n = nums.length;
        int max = nums[0];
        // 从第3个开始
        for (int i = 2; i < n; ++i) {
            if (max > nums[i]) {
                return false;
            }
            max = Math.max(max, nums[i - 1]);
        }
        return true;
    }
}
