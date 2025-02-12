package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1742. 盒子中小球的最大数量
 * 第二次
 */
public class Solution1742 {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer,Integer> count = new HashMap<>();
        int res = 0;
        for(int i = lowLimit; i <= highLimit; i++){
            int index = 0;
            int ball = i;
            while(ball > 0){
                index += ball % 10;
                ball /= 10;
            }
            count.put(index,count.getOrDefault(index,0) + 1);
            res = Math.max(res,count.get(index));
        }
        return res;
    }
}
