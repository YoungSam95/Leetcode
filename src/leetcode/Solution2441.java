package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2441. 与对应负数同时存在的最大正整数
 */
public class Solution2441 {
    public int findMaxK(int[] nums) {
        int k = -1;
        Set<Integer> set = new HashSet<Integer>();
        for (int x : nums) {
            set.add(x);
        }
        for (int x : nums) {
            if (set.contains(-x)) {
                k = Math.max(k, x);
            }
        }
        return k;
    }
}
