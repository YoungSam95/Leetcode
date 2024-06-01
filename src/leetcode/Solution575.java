package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. 分糖果
 */
public class Solution575 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<Integer>();
        for (int candy : candyType) {
            set.add(candy);
        }
        return Math.min(set.size(), candyType.length / 2);
    }
}
