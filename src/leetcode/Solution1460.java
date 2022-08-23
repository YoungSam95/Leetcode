package leetcode;

import java.util.Arrays;

/**
 * 1460. 通过翻转子数组使两个数组相等
 * 思路：只要两个数组元素相同就可以
 */
public class Solution1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target,arr);
    }
}
