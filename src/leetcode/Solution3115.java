package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 3115. 质数的最大距离
 */
public class Solution3115 {
    public int maximumPrimeDifference(int[] nums) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(
                2, 3, 5, 7, 11,
                13, 17, 19, 23, 29,
                31, 37, 41, 43, 47,
                53, 59, 61, 67, 71,
                73, 79, 83, 89, 97
        ));

        int n = nums.length;
        int first = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (primes.contains(nums[i])) {
                if (first != -1) {
                    ans = Math.max(ans, i - first);
                } else {
                    first = i;
                }
            }
        }
        return ans;
    }
}
