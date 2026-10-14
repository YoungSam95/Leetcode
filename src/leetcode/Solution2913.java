package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2913. 子数组不同元素数目的平方和 I
 */
public class Solution2913 {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size(), res = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet<>();
            for (int j = i; j < n; j++) {
                s.add(nums.get(j));
                res += s.size() * s.size();
            }
        }
        return res;
    }
}
