package leetcode;

import java.util.*;

/**
 * 1636. 按照频率将数组升序排序
 */
public class Solution1636 {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
            list.add(num);
        }
        Collections.sort(list,(a,b) -> {
            int fre1 = map.get(a), fre2 = map.get(b);
            return fre1 == fre2 ? b - a : fre1 - fre2;
        });
        for(int i = 0; i < nums.length; i++){
            nums[i] = list.get(i);
        }
        return nums;
    }
}
