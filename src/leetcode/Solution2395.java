package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2395. 和相等的子数组
 */
public class Solution2395 {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> seen = new HashSet<Integer>();
        for (int i = 0; i < n - 1; ++i) {
            int sum = nums[i] + nums[i + 1];
            if (!seen.add(sum)) {
                return true;
            }
        }
        return false;
    }
}
