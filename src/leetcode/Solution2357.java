package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2357. 使数组中所有元素都等于零
 */
public class Solution2357 {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }
}
