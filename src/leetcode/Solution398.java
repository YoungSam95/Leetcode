package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 398.随机数索引
 */
public class Solution398 {
    int[] nums;
    public Solution398(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                list.add(i);
            }
        }
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}
