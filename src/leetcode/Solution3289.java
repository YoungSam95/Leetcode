package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3289. 数字小镇中的捣蛋鬼
 */
public class Solution3289 {
    public int[] getSneakyNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int x : nums) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 2) {
                res.add(x);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
