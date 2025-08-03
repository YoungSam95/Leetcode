package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 904. 水果成篮
 * 第二次
 */
public class Solution904 {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer,Integer> map = new HashMap<>();
        int left = 0, res = 0;
        for(int right = 0; right < n; ++right) {
            map.put(fruits[right], map.getOrDefault(fruits[right],0) + 1);
            while(map.size() > 2){
                map.put(fruits[left],map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }
                ++left;
            }
            res = Math.max(res,right - left + 1);
        }
        return res;
    }
}
