package leetcode;

import java.util.Arrays;

/**
 * 532. 数组中的 k-diff 数对
 */
public class Solution532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int fast = 0, res = 0, n = nums.length;
        for(int slow = 0; slow < n; slow++){
            if(slow == 0 || nums[slow] != nums[slow - 1]){
                while(fast < n && (nums[fast] < nums[slow] + k || fast <= slow)){
                    fast++;
                }
                if(fast < n && nums[fast] == nums[slow] + k) res++;
            }
        }
        return res;
    }
}
