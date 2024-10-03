package leetcode;

/**
 * 1227. 飞机座位分配概率
 */
public class Solution1227 {
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1.0 : 0.5;
    }
}
