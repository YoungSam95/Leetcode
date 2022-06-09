package leetcode;

import java.util.Random;

/**
 * 497. 非重叠矩形中的随机点
 */
public class Solution497 {
    int[][] rects;
    int[] sum;
    int n;
    Random random;
    public Solution497(int[][] rects) {
        random = new Random();
        this.rects = rects;
        this.n = rects.length;
        this.sum = new int[n + 1];
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + (rects[i - 1][2] - rects[i - 1][0] + 1) * (rects[i - 1][3] - rects[i - 1][1] + 1);
        }
    }
    public int[] pick() {
        int val = random.nextInt(sum[n]) + 1;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (sum[mid] >= val) r = mid;
            else l = mid + 1;
        }
        int[] cur = rects[r - 1];
        int x = random.nextInt(cur[2] - cur[0] + 1) + cur[0], y = random.nextInt(cur[3] - cur[1] + 1) + cur[1];
        return new int[]{x, y};
    }
}
