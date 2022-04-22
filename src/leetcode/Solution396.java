package leetcode;

/**
 * 396.旋转函数
 *  F(i) = F(i-1) + sum - n * A(n-i)
 */
public class Solution396 {

    public static int maxRotateFunction(int[] nums) {
        int sum = 0, f = 0, n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i]; // 计算F(0)
        }
        ans = f;
        for (int i = 1; i < n; i++) { // 迭代计算F(i)
            f = f + sum - n * nums[n-i]; // F(i) = F(i-1) + sum - n * A(n-i)
            ans = Math.max(ans, f);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(maxRotateFunction(nums));
    }
}
