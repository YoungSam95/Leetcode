package leetcode;

import java.util.*;

/**
 * 970. 强整数
 */
public class Solution970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<Integer>();
        int value1 = 1;
        for (int i = 0; i < 21; i++) {
            int value2 = 1;
            for (int j = 0; j < 21; j++) {
                int value = value1 + value2;
                if (value <= bound) {
                    set.add(value);
                } else {
                    break;
                }
                value2 *= y;
            }
            if (value1 > bound) {
                break;
            }
            value1 *= x;
        }
        return new ArrayList<Integer>(set);
    }
}
