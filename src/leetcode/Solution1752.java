package leetcode;

/**
 * 1752. 检查数组是否经排序和轮转得到
 */
public class Solution1752 {
    public boolean check(int[] nums) {
        int cut = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i + 1]){
                cut++;
            }
        }
        if(cut > 1) return false;
        if(cut == 0) return true;
        return nums[nums.length - 1] <= nums[0];
    }
}
