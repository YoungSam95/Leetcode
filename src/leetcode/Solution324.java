package leetcode;

/**
 * 324. 摆动排序 II
 */
public class Solution324 {
    public void wiggleSort(int[] nums) {
        int[] bucket = new int[5001];
        for(int num : nums){
            bucket[num]++;
        }
        int j = 5000;
        for(int i = 1; i < nums.length; i += 2){
            while(bucket[j] == 0){
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }
        for(int i = 0; i < nums.length; i += 2){
            while(bucket[j] == 0){
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }
    }
}
