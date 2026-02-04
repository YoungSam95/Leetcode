package leetcode;

/**
 * 3379. 转换数组
 */
public class Solution3379 {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[((i + nums[i]) % n + n) % n];
        }
        return res;
    }

}
