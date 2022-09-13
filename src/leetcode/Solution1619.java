package leetcode;

import java.util.Arrays;

/**
 * 1619. 删除某些元素后的数组均值
 */
public class Solution1619 {
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = n / 20; i < 19 * n / 20; i++) {
            sum += arr[i];
        }
        return sum / (n * 0.9);
    }
}
