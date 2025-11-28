package leetcode;

/**
 * 3512. 使数组和能被 K 整除的最少操作次数
 */
public class Solution3512 {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }
}
