package leetcode;

/**
 * 3739. 统计主要元素子数组数目 II
 */
public class Solution3739 {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        // 表示前缀和为 -n, -(n-1), ..., 0, 1, ..., n 的出现次数，下标偏移 n
        int[] pre = new int[n * 2 + 1];
        pre[n] = 1;
        int cnt = n;
        long ans = 0, presum = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == target) {
                presum += pre[cnt];
                ++cnt;
                ++pre[cnt];
            } else {
                --cnt;
                presum -= pre[cnt];
                ++pre[cnt];
            }
            ans += presum;
        }
        return ans;
    }
}
