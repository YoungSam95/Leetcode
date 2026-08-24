package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3718. 缺失的最小倍数
 */
public class Solution3718 {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        int ans = k;
        while (seen.contains(ans)) {
            ans += k;
        }
        return ans;
    }
}
