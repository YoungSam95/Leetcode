package leetcode;

import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 */
public class Solution1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if(n - i <= nums[i]){
                if(i == 0 || nums[i - 1] < n - i){
                    return n - i;
                }
            }
        }
        return -1;
    }
}
