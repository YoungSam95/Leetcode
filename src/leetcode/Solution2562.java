package leetcode;

/**
 * 2562. 找出数组的串联值
 */
public class Solution2562 {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (i != j) {
                ans += Integer.parseInt(Integer.toString(nums[i]) + Integer.toString(nums[j]));
            } else {
                ans += nums[i];
            }
        }
        return ans;
    }
}
