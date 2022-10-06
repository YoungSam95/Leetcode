package leetcode;

/**
 * 1800. 最大升序子数组和
 */
public class Solution1800 {
    public int maxAscendingSum(int[] nums) {
        int res = 0, curr = 0;
        for(int i = 0; i < nums.length; i++){
            curr += nums[i];
            if(i + 1 >= nums.length || nums[i] >= nums[i + 1]){
                res = Math.max(res,curr);
                curr = 0;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {10,20,30,5,10,50};
        System.out.println(new Solution1800().maxAscendingSum(nums));
    }
}
