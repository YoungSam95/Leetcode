package leetcode;

/**
 * 53. 最大子数组和
 *     给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 第二次
 */
public class Solution53 {

    public static int maxSubArray(int[] nums) {
        /**
         * dp[i] = 以nums[i]为结尾的最大子数组和
         * 状态转移方程为dp[i] = max{nums[i],nums[i]+dp[i-1]}
         */
        /*if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;*/
        //注意到 dp[i] 仅仅和 dp[i-1] 的状态有关,所以优化
        if (nums.length == 0) return 0;
        // base case
        int dp_0 = nums[0];
        int dp_1 = 0, res = dp_0;

        for (int i = 1; i < nums.length; i++) {
            // dp[i] = max(nums[i], nums[i] + dp[i-1])
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            dp_0 = dp_1;
            // 顺便计算最大的结果
            res = Math.max(res, dp_1);
        }

        return res;
    }
    
    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}
