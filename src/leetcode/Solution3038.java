package leetcode;

/**
 * 3038. 相同分数的最大操作数目 I
 */
public class Solution3038 {
    public int maxOperations(int[] nums) {
        int n = nums.length, t = 0;
        for (int i = 1; i < n; i += 2) {
            if (nums[i] + nums[i - 1] != nums[1] + nums[0]) {
                break;
            }
            t++;
        }
        return t;
    }
}
