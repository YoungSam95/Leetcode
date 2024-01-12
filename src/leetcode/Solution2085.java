package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2085. 统计出现过一次的公共字符串
 */
public class Solution2085 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> freq1 = new HashMap<>();
        Map<String, Integer> freq2 = new HashMap<>();
        for (String w : words1) {
            freq1.put(w, freq1.getOrDefault(w, 0) + 1);
        }
        for (String w : words2) {
            freq2.put(w, freq2.getOrDefault(w, 0) + 1);
        }
        int res = 0;
        for (String w : freq1.keySet()) {
            if (freq1.get(w) == 1 && freq2.getOrDefault(w, 0) == 1) {
                res++;
            }
        }
        return res;
    }
}
