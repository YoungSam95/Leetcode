package leetcode;

/**
 * 2873. 有序三元组中的最大值 I
 */
public class Solution2873 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int k = 2; k < n; k++) {
            int m = nums[0];
            for (int j = 1; j < k; j++) {
                res = Math.max(res, (long)(m - nums[j]) * nums[k]);
                m = Math.max(m, nums[j]);
            }
        }
        return res;
    }
}
