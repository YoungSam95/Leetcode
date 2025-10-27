package leetcode;

/**
 * 3354. 使数组元素等于零
 */
public class Solution3354 {
    public int countValidSelections(int[] nums) {
        int n = nums.length, ans = 0, sum = 0;
        for (int x : nums) {
            sum += x;
        }
        int leftSum = 0, rightSum = sum;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (leftSum - rightSum >= 0 && leftSum - rightSum <= 1) {
                    ans++;
                }
                if (rightSum - leftSum >= 0 && rightSum - leftSum <= 1) {
                    ans++;
                }
            } else {
                leftSum += nums[i];
                rightSum -= nums[i];
            }
        }
        return ans;
    }
}
