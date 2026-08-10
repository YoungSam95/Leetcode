package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2996. 大于等于顺序前缀和的最小缺失整数
 */
public class Solution2996 {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        Set<Integer> numSet = new HashSet<>(n);
        for (int num : nums) {
            numSet.add(num);
        }
        int total = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                total += nums[i];
            } else {
                break;
            }
        }

        while (numSet.contains(total)) {
            total += 1;
        }

        return total;
    }
}
