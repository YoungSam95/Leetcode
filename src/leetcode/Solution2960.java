package leetcode;

/**
 * 2960. 统计已测试设备
 */
public class Solution2960 {
    public int countTestedDevices(int[] batteryPercentages) {
        int n = batteryPercentages.length;
        int need = 0;
        for (int i = 0; i < n; i++) {
            if (batteryPercentages[i] > 0) {
                need++;
                for (int j = i + 1; j < n; j++) {
                    batteryPercentages[j] = Math.max(batteryPercentages[j] - 1, 0);
                }
            }
        }
        return need;
    }
}
