package leetcode;

import java.util.*;

/**
 * 2404. 出现最频繁的偶数元素
 */
public class Solution2404 {
    public int mostFrequentEven(int[] nums) {
        int res = -1, max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums) {
            if(num % 2 == 0) {
                map.put(num,map.getOrDefault(num,0) + 1);
                int temp = map.get(num);
                if(temp > max){
                    max = temp;
                    res = num;
                }else if(temp == max){
                    res = Math.min(res,num);
                }
            }
        }
        return res;
    }
}
