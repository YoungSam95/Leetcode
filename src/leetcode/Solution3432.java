package leetcode;

/**
 * 3432. 统计元素和差值为偶数的分区方案
 */
public class Solution3432 {
    public int countPartitions(int[] nums) {
        int totalSum = 0;
        for (int x : nums) {
            totalSum += x;
        }
        return totalSum % 2 == 0 ? nums.length - 1 : 0;
    }
}
