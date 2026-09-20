package leetcode;

/**
 * 3524. 求出数组的 X 值 I
 */
public class Solution3524 {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] result = new long[k];
        long[] dp = new long[k];  // 初始状态，表示尚未处理任何元素，因此不存在非空子数组

        for (int i = 0; i < n; i++) {
            long[] ndp = new long[k];  // 当前层状态（滚动数组）
            ndp[nums[i] % k]++;
            for (int r = 0; r < k; r++) {
                ndp[(int)(((long)r * nums[i]) % k)] += dp[r];
            }
            dp = ndp;  // 更新状态
            // 累加答案
            for (int r = 0; r < k; r++) {
                result[r] += dp[r];
            }
        }

        return result;
    }
}
