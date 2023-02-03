package leetcode;

import java.util.Arrays;

/**
 * 1798. 你能构造出连续值的最大数目
 */
public class Solution1798 {
    public int getMaximumConsecutive(int[] coins) {
        int res = 1;
        Arrays.sort(coins);
        for (int i : coins) {
            if (i > res) {
                break;
            }
            res += i;
        }
        return res;
    }
}
