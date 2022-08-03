package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1403. 非递增顺序的最小子序列
 */
public class Solution1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int curr = 0;
        int sum = 0;
        for(int num : nums) sum += num;
        for(int i = nums.length - 1; i >= 0; i--){
            curr += nums[i];
            res.add(nums[i]);
            if(sum - curr < curr) break;
        }
        return res;
    }
}
