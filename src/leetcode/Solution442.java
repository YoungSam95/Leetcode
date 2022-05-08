package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 442. 数组中重复的数据
 */
public class Solution442 {
    public static List<Integer> findDuplicates(int[] nums) {
        /**
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for(int i : map.keySet()){
            if(map.get(i) == 2){
                res.add(i);
            }
        }
        return res;
         **/
        /**取反**/
        /*List<Integer> res = new ArrayList<>();
        for(int num : nums){
            int x = Math.abs(num);
            if(nums[x -1] < 0){
                res.add(x);
            }else{
                nums[x - 1] *= -1;
            }
        }
        return res;*/
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (nums[i] - 1 != i) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }
}
