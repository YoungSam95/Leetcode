package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2553. 分割数组中数字的数位
 */
public class Solution2553 {
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int x = nums[i];
            while (x > 0) {
                res.add(x % 10);
                x /= 10;
            }
        }

        Collections.reverse(res);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
