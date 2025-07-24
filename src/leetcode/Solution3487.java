package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 3487. 删除后的最大子数组元素和
 */
public class Solution3487 {
    public int maxSum(int[] nums) {
        Set<Integer> positiveNumsSet = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                positiveNumsSet.add(num);
            }
        }
        if (positiveNumsSet.isEmpty()) {
            return Arrays.stream(nums).max().getAsInt();
        }
        return positiveNumsSet.stream().mapToInt(Integer::intValue).sum();
    }
}
