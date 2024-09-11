package leetcode;

import java.util.Arrays;

/**
 * 2576. 求出最多标记下标
 */
public class Solution2576 {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = n / 2;
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (check(nums, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l * 2;
    }

    public boolean check(int[] nums, int m) {
        int n = nums.length;
        for (int i = 0; i < m; i++) {
            if (nums[i] * 2 > nums[n - m + i]) {
                return false;
            }
        }
        return true;
    }
}
