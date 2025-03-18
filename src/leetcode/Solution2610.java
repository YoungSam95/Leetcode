package leetcode;

import java.util.*;

/**
 * 2610. 转换二维数组
 */
public class Solution2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!cnt.isEmpty()) {
            List<Integer> arr = new ArrayList<>();
            Iterator<Map.Entry<Integer, Integer>> it = cnt.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                entry.setValue(entry.getValue() - 1);
                arr.add(entry.getKey());
                if (entry.getValue() == 0) {
                    it.remove();
                }
            }
            ans.add(arr);
        }

        return ans;
    }
}
