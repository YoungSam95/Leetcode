package leetcode;

import java.util.Arrays;

/**
 * 2656. K 个元素的最大和
 */
public class Solution2656 {
    public int maximizeSum(int[] nums, int k) {
        int m = Arrays.stream(nums).max().getAsInt();
        return (2 * m + k - 1) * k / 2;
    }
}
