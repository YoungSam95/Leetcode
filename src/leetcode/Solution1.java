package leetcode;
/**
 * 1.两数之和
 *   给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
 *   你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *解题思路：数组放入Map中，检查是否是重复元素。时间复杂度O(n),暴力解法时间复杂度为O(n²)。
 */

import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int temp = target-nums[i];
            if(map.containsKey(temp) && map.get(temp) != i){
                return new int[] {i,map.get(temp)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args){

        int[] nums = {2,7,11,15};
        int target = 9;
        int[] res = new int[2];
        res = twoSum(nums,target);
        for(int i : res){
            System.out.println(i);
        }
    }
}