package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2391. 收集垃圾的最少总时间
 */
public class Solution2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        Map<Character, Integer> distance = new HashMap<>();
        int res = 0, curDis = 0;
        for (int i = 0; i < garbage.length; i++) {
            res += garbage[i].length();
            if (i > 0) {
                curDis += travel[i - 1];
            }
            for (char c : garbage[i].toCharArray()) {
                distance.put(c, curDis);
            }
        }
        return res + distance.values().stream().reduce(0, Integer::sum);
    }
}
