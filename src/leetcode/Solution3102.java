package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 3102. 最小化曼哈顿距离
 */
public class Solution3102 {
    public int minimumDistance(int[][] points) {
        int n = points.length;
        List<int[]> sx = new ArrayList<int[]>();
        List<int[]> sy = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            sx.add(new int[]{x - y, i});
            sy.add(new int[]{x + y, i});
        }
        sx.sort((a, b) -> a[0] - b[0]);
        sy.sort((a, b) -> a[0] - b[0]);
        int maxVal1 = sx.get(sx.size() - 1)[0] - sx.get(0)[0];
        int maxVal2 = sy.get(sy.size() - 1)[0] - sy.get(0)[0];
        int res = Integer.MAX_VALUE;
        if (maxVal1 >= maxVal2) {
            int i = sx.get(0)[1], j = sx.get(sx.size() - 1)[1];
            // 去掉 i 后的最大曼哈顿距离
            res = Math.min(res, Math.max(remove(sx, i), remove(sy, i)));
            // 去掉 j 后的最大曼哈顿距离
            res = Math.min(res, Math.max(remove(sx, j), remove(sy, j)));
        } else {
            int i = sy.get(0)[1], j = sy.get(sy.size() - 1)[1];
            // 去掉 i 后的最大曼哈顿距离
            res = Math.min(res, Math.max(remove(sx, i), remove(sy, i)));
            // 去掉 j 后的最大曼哈顿距离
            res = Math.min(res, Math.max(remove(sx, j), remove(sy, j)));
        }
        return res;
    }

    public int remove(List<int[]> arr, int i) {
        int n = arr.size();
        if (arr.get(0)[1] == i) {
            return arr.get(n - 1)[0] - arr.get(1)[0];
        } else if (arr.get(n - 1)[1] == i) {
            return arr.get(n - 2)[0] - arr.get(0)[0];
        } else {
            return arr.get(n - 1)[0] - arr.get(0)[0];
        }
    }
}
