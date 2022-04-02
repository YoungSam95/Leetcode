package leetcode;

/**
 * 35.搜索插入位置
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
