package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3043. 最长公共前缀的长度
 */
public class Solution3043 {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr1) {
            while (num > 0) {
                seen.add(num);
                num /= 10;
            }
        }

        int best = 0;
        for (int num : arr2) {
            while (num > 0) {
                if (seen.contains(num)) {
                    best = Math.max(best, num);
                }
                num /= 10;
            }
        }

        return best == 0 ? 0 : String.valueOf(best).length();
    }
}
