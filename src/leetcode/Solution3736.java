package leetcode;

/**
 * 3736. 最小操作次数使数组元素相等 III
 */
public class Solution3736 {
    public int minMoves(int[] nums) {
        int mx = nums[0];
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        int ans = 0;
        for (int x : nums) {
            ans += mx - x;
        }
        return ans;
    }
}
