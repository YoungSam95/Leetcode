package leetcode;

/**
 * 2651. 计算列车到站时间
 */
public class Solution2651 {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return arrivalTime + delayedTime >= 24 ? arrivalTime + delayedTime - 24 : arrivalTime + delayedTime;
    }
}
