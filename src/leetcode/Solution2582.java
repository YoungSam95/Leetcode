package leetcode;

/**
 * 2582. 递枕头
 */
public class Solution2582 {
    public int passThePillow(int n, int time) {
        time %= (n - 1) * 2;
        return time < n ? time + 1 : n * 2 - time - 1;
    }
}
