package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2200. 找出数组中的所有 K 近邻下标
 */
public class Solution2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        int r = 0; // 未被判断过的最小下标
        int n = nums.length;
        for (int j = 0; j < n; ++j) {
            if (nums[j] == key) {
                int l = Math.max(r, j - k);
                r = Math.min(n - 1, j + k) + 1;
                for (int i = l; i < r; ++i) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
