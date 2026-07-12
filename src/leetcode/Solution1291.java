package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1291. 顺次数
 */
public class Solution1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            int num = i;
            for (int j = i + 1; j <= 9; j++) {
                num = num * 10 + j;
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }
        ans.sort((a, b) -> a - b);
        return ans;
    }
}
