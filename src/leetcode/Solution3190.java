package leetcode;

import java.util.Arrays;

/**
 * 3190. 使所有元素都可以被 3 整除的最少操作数
 */
public class Solution3190 {
    public int minimumOperations(int[] nums) {
        return Arrays.stream(nums)
                .map(x -> Math.min(x % 3, 3 - x % 3))
                .sum();
    }
}
