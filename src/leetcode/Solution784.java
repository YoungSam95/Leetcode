package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 784. 字母大小写全排列
 */
public class Solution784 {
    private List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        backTracking(ch, 0, n);
        return res;
    }

    private void backTracking(char[] ch, int index, int n) {
        res.add(new String(ch));
        for (int i = index; i < n; i++) {
            if (Character.isDigit(ch[i])) {
                continue;
            }
            ch[i] ^= 32;
            backTracking(ch, i + 1, n);
            ch[i] ^= 32;
        }
    }
}
