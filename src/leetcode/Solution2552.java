package leetcode;

/**
 * 2552. 统计上升四元组
 */
public class Solution2552 {
    public long countQuadruplets(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        long ans = 0;
        for (int j = 0; j < n; ++j) {
            int suf = 0;
            for (int k = n - 1; k > j; --k) {
                if (nums[j] > nums[k]) {
                    ans += (long) pre[nums[k]] * suf;
                } else {
                    ++suf;
                }
            }
            for (int x = nums[j] + 1; x <= n; ++x) {
                ++pre[x];
            }
        }
        return ans;
    }
}
