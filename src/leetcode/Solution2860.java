package leetcode;

import java.util.Collections;
import java.util.List;

/**
 * 2860. 让所有学生保持开心的分组方法数
 */
public class Solution2860 {
    public int countWays(List<Integer> nums) {
        int n = nums.size();
        int res = 0;
        Collections.sort(nums);
        for (int k = 0; k <= n; k++) {
            // 前 k 个元素的最大值是否小于 k
            if (k > 0 && nums.get(k - 1) >= k) {
                continue;
            }
            // 后 n - k 个元素的最小值是否大于 k
            if (k < n && nums.get(k) <= k) {
                continue;
            }
            res++;
        }
        return res;
    }
}
