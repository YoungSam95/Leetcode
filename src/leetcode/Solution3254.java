package leetcode;

import java.util.Arrays;

/**
 * 3254. 长度为 K 的子数组的能量值 I
 */
public class Solution3254 {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Arrays.fill(ans, -1);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt = i == 0 || nums[i] - nums[i - 1] != 1 ? 1 : cnt + 1;
            if (cnt >= k) {
                ans[i - k + 1] = nums[i];
            }
        }
        return ans;
    }
}
