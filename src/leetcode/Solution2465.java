package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2465. 不同的平均值数目
 */
public class Solution2465 {
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> seen = new HashSet<Integer>();
        for (int i = 0, j = nums.length - 1; i < j; ++i, --j) {
            seen.add(nums[i] + nums[j]);
        }
        return seen.size();
    }
}
