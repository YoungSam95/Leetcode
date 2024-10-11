package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3158. 求出出现两次数字的 XOR 值
 */
public class Solution3158 {
    public int duplicateNumbersXOR(int[] nums) {
        Set<Integer> cnt = new HashSet<>();
        int res = 0;
        for (int num : nums) {
            if (cnt.contains(num)) {
                res ^= num;
            } else {
                cnt.add(num);
            }
        }
        return res;
    }
}
