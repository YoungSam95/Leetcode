package leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * 3016. 输入单词需要的最少按键次数 II
 */
public class Solution3016 {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        Integer[] freqBoxed = Arrays.stream(freq).boxed().toArray(Integer[]::new);
        Arrays.sort(freqBoxed, Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < 26 && freqBoxed[i] > 0; i++) {
            ans += (i / 8 + 1) * freqBoxed[i];
        }
        return ans;
    }
}
