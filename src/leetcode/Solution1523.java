package leetcode;

/**
 * 1523. 在区间范围内统计奇数数目
 */
public class Solution1523 {
    public int countOdds(int low, int high) {
        return pre(high) - pre(low - 1);
    }

    public int pre(int x) {
        return (x + 1) >> 1;
    }
}
