package leetcode;

/**
 * 2469. 温度转换
 */
public class Solution2469 {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15, celsius * 1.80 + 32.00};
    }
}
