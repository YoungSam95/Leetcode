package leetcode;

/**
 * 3637. 三段式数组 I
 */
public class Solution3637 {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        // 第一段
        int i = 1;
        while (i < n && nums[i - 1] < nums[i]) {
            i++;
        }
        if (i == 1) { // 第一段至少要有两个数
            return false;
        }

        // 第二段
        int i0 = i;
        while (i < n && nums[i - 1] > nums[i]) {
            i++;
        }
        if (i == i0 || i == n) { // 第二段至少要有两个数，第三段至少要有两个数
            return false;
        }

        // 第三段
        while (i < n && nums[i - 1] < nums[i]) {
            i++;
        }
        return i == n;
    }
}
