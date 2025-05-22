package leetcode;

import java.util.Arrays;

/**
 * 3068. 最大节点价值之和
 */
public class Solution3068 {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long res = 0;
        int[] diff = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            res += nums[i];
            diff[i] = (nums[i] ^ k) - nums[i];
        }
        Arrays.sort(diff);
        for (int i = diff.length - 1; i > 0 && diff[i] + diff[i - 1] >= 0; i -= 2) {
            res += diff[i] + diff[i - 1];
        }
        return res;
    }
}
