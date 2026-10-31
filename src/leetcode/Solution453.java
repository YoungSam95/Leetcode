package leetcode;

import java.util.Arrays;

/**
 * 453. 最小操作次数使数组元素相等
 */
public class Solution453 {
    public int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }
}
