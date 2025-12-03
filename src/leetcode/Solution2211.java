package leetcode;

/**
 * 2211. 统计道路上的碰撞次数
 */
public class Solution2211 {
    public int countCollisions(String directions) {
        int n = directions.length();
        int l = 0, r = n - 1;

        while (l < n && directions.charAt(l) == 'L') {
            l++;
        }

        while (r >= l && directions.charAt(r) == 'R') {
            r--;
        }

        int res = 0;
        for (int i = l; i <= r; i++) {
            if (directions.charAt(i) != 'S') {
                res++;
            }
        }
        return res;
    }
}
