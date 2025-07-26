package leetcode;

/**
 * 2210. 统计数组中峰和谷的数量
 */
public class Solution2210 {
    public int countHillValley(int[] nums) {
        int res = 0;   // 峰与谷的数量
        int n = nums.length;
        for (int i = 1; i < n - 1; ++i) {
            if (nums[i] == nums[i - 1]) {
                // 去重
                continue;
            }
            int left = 0;   // 左边可能的不相等邻居对应状态
            for (int j = i - 1; j >= 0; --j) {
                if (nums[j] > nums[i]) {
                    left = 1;
                    break;
                } else if (nums[j] < nums[i]) {
                    left = -1;
                    break;
                }
            }
            int right = 0;   // 右边可能的不相等邻居对应状态
            for (int j = i + 1; j < n; ++j) {
                if (nums[j] > nums[i]) {
                    right = 1;
                    break;
                } else if (nums[j] < nums[i]) {
                    right = -1;
                    break;
                }
            }
            if (left == right && left != 0) {
                // 此时下标 i 为峰或谷的一部分
                ++res;
            }
        }
        return res;
    }
}
