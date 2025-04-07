package leetcode;

/**
 * 3396. 使数组元素互不相同所需的最少操作次数
 */
public class Solution3396 {
    public int minimumOperations(int[] nums) {
        boolean[] seen = new boolean[128];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (seen[nums[i]]) {
                return i / 3 + 1;
            }
            seen[nums[i]] = true;
        }
        return 0;
    }
}
