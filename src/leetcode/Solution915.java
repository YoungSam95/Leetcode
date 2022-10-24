package leetcode;

/**
 * 915. 分割数组
 */
public class Solution915 {
    public int partitionDisjoint(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = nums[0];
        int max = left[0];
        for(int i = 1; i < n; i++){
            if(nums[i] > max) max = nums[i];
            left[i] = max;
        }
        right[n - 1] = nums[n - 1];
        int min = right[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if(nums[i + 1] < min) min = nums[ i + 1];
            right[i] = min;
        }
        for(; res < n - 1; res++){
            if(left[res] <= right[res]) break;
        }
        return res + 1;
    }
    public int partitionDisjoint1(int[] nums) {
        int n = nums.length;
        int leftMax = nums[0], leftPos = 0, curMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            curMax = Math.max(curMax, nums[i]);
            if (nums[i] < leftMax) {
                leftMax = curMax;
                leftPos = i;
            }
        }
        return leftPos + 1;
    }
}
