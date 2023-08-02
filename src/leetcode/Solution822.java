package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 822. 翻转卡片游戏
 */
public class Solution822 {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> same = new HashSet();
        for (int i = 0; i < fronts.length; ++i) {
            if (fronts[i] == backs[i]) {
                same.add(fronts[i]);
            }
        }
        int res = 3000;
        for (int x : fronts) {
            if (x < res && !same.contains(x)){
                res = x;
            }
        }
        for (int x : backs) {
            if (x < res && !same.contains(x)) {
                res = x;
            }
        }
        return res % 3000;
    }
}
