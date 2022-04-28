package leetcode;

/**
 * 905. 按奇偶排序数组
 */

public class Solution905 {

    public static int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            while(left < right && nums[left]%2 == 0){
                left++;
            }
            while(left < right && nums[right]%2 == 1){
                right--;
            }
            if(left < right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
    public static void main(String[] args){
        int[] nums = {3,1,2,4};
        System.out.println(sortArrayByParity(nums));
    }
}
