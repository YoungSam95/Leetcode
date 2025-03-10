package leetcode;

/**
 * 2012. 数组美丽值求和
 */
public class Solution2012 {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] state = new int[n];
        int pre_max = nums[0];
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > pre_max) {
                state[i] = 1;
                pre_max = nums[i];
            }
        }
        int suf_min = nums[n - 1];
        int res = 0;
        for (int i = n - 2; i > 0; i--) {
            if (state[i] == 1 && nums[i] < suf_min) {
                res += 2;
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                res += 1;
            }
            suf_min = Math.min(suf_min, nums[i]);
        }
        return res;
    }
}
