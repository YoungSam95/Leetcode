package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3375. 使数组的值全部为 K 的最少操作次数
 */
public class Solution3375 {
    public int minOperations(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        for (int x : nums) {
            if (x < k) {
                return -1;
            } else if (x > k) {
                st.add(x);
            }
        }
        return st.size();
    }
}
