package leetcode;

import java.util.*;

/**
 * 1338. 数组大小减半
 */
public class Solution1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> occ = new ArrayList<>(freq.values());
        Collections.sort(occ, Collections.reverseOrder());
        int cnt = 0, ans = 0;
        for (int c : occ) {
            cnt += c;
            ans += 1;
            if (cnt * 2 >= arr.length) {
                break;
            }
        }
        return ans;
    }
}
