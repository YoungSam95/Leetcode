package leetcode;

import java.util.Arrays;

/**
 * 2386. 找出数组的第 K 大和
 */
public class Solution2386 {
    int cnt;

    public long kSum(int[] nums, int k) {
        int n = nums.length;
        long total = 0, total2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                total += nums[i];
            } else {
                nums[i] = -nums[i];
            }
            total2 += Math.abs(nums[i]);
        }
        Arrays.sort(nums);

        long left = 0, right = total2;
        while (left <= right) {
            long mid = (left + right) / 2;
            cnt = 0;
            dfs(nums, k, n, 0, 0, mid);
            if (cnt >= k - 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return total - left;
    }

    public void dfs(int[] nums, int k, int n, int i, long t, long limit) {
        if (i == n || cnt >= k - 1 || t + nums[i] > limit) {
            return;
        }
        cnt++;
        dfs(nums, k, n, i + 1, t + nums[i], limit);
        dfs(nums, k, n, i + 1, t, limit);
    }
}
