package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 3159. 查询数组中元素的出现位置
 */
public class Solution3159 {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                indices.add(i);
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (indices.size() < queries[i]) {
                res[i] = -1;
            } else {
                res[i] = indices.get(queries[i] - 1);
            }
        }
        return res;
    }
}
