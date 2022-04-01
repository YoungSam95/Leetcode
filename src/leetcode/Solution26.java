package leetcode;

/**
 * 26. 删除有序数组中的重复项
 * 思路：使用快慢双指针
 */

public class Solution26 {

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int slow = 0, fast = 0;
        while(fast < nums.length){
            if(nums[slow] != nums[fast]){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

    public static void main(String[] args){
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}
