package leetcode;

import java.util.*;

/**
 * 710. 黑名单中的随机数
 */
public class Solution710 {

    Map<Integer, Integer> b2w;
    Random random;
    int bound;

    public Solution710(int n, int[] blacklist) {
        b2w = new HashMap<Integer, Integer>();
        random = new Random();
        int m = blacklist.length;
        bound = n - m;
        Set<Integer> black = new HashSet<Integer>();
        for (int b : blacklist) {
            if (b >= bound) {
                black.add(b);
            }
        }

        int w = bound;
        for (int b : blacklist) {
            if (b < bound) {
                while (black.contains(w)) {
                    ++w;
                }
                b2w.put(b, w);
                ++w;
            }
        }
    }

    public int pick() {
        int x = random.nextInt(bound);
        return b2w.getOrDefault(x, x);
    }
}
