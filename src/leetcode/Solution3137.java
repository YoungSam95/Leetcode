package leetcode;

import java.util.HashMap;

/**
 * 3137. K 周期字符串需要的最少操作次数
 */
public class Solution3137 {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length(), res = Integer.MAX_VALUE;
        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i += k) {
            String part = word.substring(i, i + k);
            res = Math.min(res, n / k - count.merge(part, 1, Integer::sum));
        }
        return res;
    }
}
