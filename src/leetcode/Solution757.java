package leetcode;

import java.util.Arrays;

/**
 * 757. 设置交集大小至少为2
 * 第二次
 */
public class Solution757 {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
            return a[1] != b[1] ? a[1] - b[1] : b[0] - a[0];
        });
        int a = -1, b = -1, ans = 0;
        for (int[] i : intervals) {
            if (i[0] > b) {
                a = i[1] - 1; b = i[1];
                ans += 2;
            } else if (i[0] > a) {
                a = b; b = i[1];
                ans++;
            }
        }
        return ans;
    }
}
