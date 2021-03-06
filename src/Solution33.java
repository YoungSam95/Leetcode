/**
 * 33. 搜索旋转排序数组
 *    假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *    你的算法时间复杂度必须是 O(log n) 级别.
 * 解题思路：
 *    把数组分为两段，转眼看mid落在哪个段落，对每一段的有序数组进行二分查找；
 */
public class Solution33 {

    public static int search(int[] nums,int target){


        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;
        }

        int start = 0,end = nums.length - 1;

        while(start <= end){

            int mid = (start + end )/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[start]){
                if(target < nums[mid] && target >= nums[start]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int nums[] = {16,17,18,19,20,21,2,3,4};
        int target = 2;
        System.out.println(search(nums,target));
    }
}
