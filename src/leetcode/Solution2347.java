package leetcode;

import java.util.*;

/**
 * 2347. 最好的扑克手牌
 */
public class Solution2347 {
    public String bestHand(int[] ranks, char[] suits) {
        Set<Character> suitsSet = new HashSet<Character>();
        for (char suit : suits) {
            suitsSet.add(suit);
        }
        if (suitsSet.size() == 1) {
            return "Flush";
        }
        Map<Integer, Integer> h = new HashMap<Integer, Integer>();
        for (int rank : ranks) {
            h.put(rank, h.getOrDefault(rank, 0) + 1);
        }
        if (h.size() == 5) {
            return "High Card";
        }
        for (Map.Entry<Integer, Integer> entry : h.entrySet()) {
            if (entry.getValue() > 2) {
                return "Three of a Kind";
            }
        }
        return "Pair";
    }
}
