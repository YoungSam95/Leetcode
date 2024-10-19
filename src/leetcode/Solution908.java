package leetcode;

/**
 * 908.最小差值Ⅰ
 * 思路：看最值可否足够接近，可以就是0，不可以就是最小差值
 * 第二次
 */
public class Solution908 {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        return Math.max(0,max - min - 2 * k);
    }
}
