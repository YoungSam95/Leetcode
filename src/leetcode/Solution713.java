package leetcode;

/**
 * 713. 乘积小于 K 的子数组
 */
public class Solution713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        /**int res = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < k){
                res++;
                int temp = nums[i];
                for(int j = i + 1; j < nums.length; j++){
                    temp *=nums[j];
                    if(temp < k){
                        res++;
                    }else{
                        break;
                    }
                }
            }else{
                continue;
            }
        }
        return res;*/
        int n = nums.length, res = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            res += j - i + 1;
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {100,5,2,6};
        System.out.println(numSubarrayProductLessThanK(nums,100));
    }
}
