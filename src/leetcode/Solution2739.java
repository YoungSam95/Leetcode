package leetcode;

/**
 * 2739. 总行驶距离
 */
public class Solution2739 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        return 10 * (mainTank + Math.min((mainTank - 1) / 4, additionalTank));
    }
}
