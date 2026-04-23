package leetcode;

/**
 * 2833. 距离原点最远的点
 */
public class Solution2833 {
    public int furthestDistanceFromOrigin(String moves) {
        int L = 0, R = 0, B = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                L++;
            } else if (c == 'R') {
                R++;
            } else {
                B++;
            }
        }
        return Math.abs(L - R) + B;
    }
}
