package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 */
public class Solution961 {
    public static int repeatedNTimes(int[] nums) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
            if(map.get(num) == 2){
                res = num;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {5,1,5,2,5,3,5,4};
        System.out.println(repeatedNTimes(nums));
    }
}
