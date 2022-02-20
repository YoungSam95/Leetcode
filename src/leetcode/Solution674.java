package leetcode;

/**
 * 674. 最长连续递增序列
 *      给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度。
 * 解题思路：
 *      用两个变量记录序列开始和结束的下标
 *      从左到右遍历，如果下一个节点小当前节点则移动 start，否则移动end，并更新 max
 */
public class Solution674 {

    public static int findLengthOfLCIS(int[] nums) {

        /* int ans = 0;
         int start = 0;
         for(int i = 0;i < nums.length;i++){
             if(i > 0 && nums[i] <= nums[i - 1]){
                 start = i;
             }
             ans =Math.max(ans,i-start+1);
         }
         return ans;
        */
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int start = 0, end = 0;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                end = i;
                max = Math.max(max, end - start + 1);
            } else {
                start = i;
            }
        }

        return max;
    }

    public static void main(String[] args){
        int[] nums = {1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));
    }
}
