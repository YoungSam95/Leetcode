package leetcode;

/**
 * 2176. 统计数组中相等且可以被整除的数对
 */
public class Solution2176 {
    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int res = 0;   // 符合要求数对个数
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((i * j) % k == 0 && nums[i] == nums[j]) {
                    ++res;
                }
            }
        }
        return res;
    }
}
