package huawei;

public class Solution1125 {
    public int binarySearch(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5,6,8};
        System.out.println(new Solution1125().binarySearch(nums,7));
    }
}
