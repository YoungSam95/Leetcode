package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 3453. 分割正方形 I
 */
public class Solution3453 {
    public double separateSquares(int[][] squares) {
        long totalArea = 0;
        List<int[]> events = new ArrayList<>();

        for (int[] sq : squares) {
            int y = sq[1], l = sq[2];
            totalArea += (long) l * l;
            events.add(new int[]{y, l, 1});
            events.add(new int[]{y + l, l, -1});
        }

        // 按y坐标排序
        events.sort((a, b) -> Integer.compare(a[0], b[0]));
        double coveredWidth = 0;  // 当前扫描线下所有底边之和
        double currArea = 0;      // 当前累计面积
        double prevHeight = 0;    // 前一个扫描线的高度

        for (int[] event : events) {
            int y = event[0];
            int l = event[1];
            int delta = event[2];

            int diff = y - (int) prevHeight;
            // 两条扫描线之间新增的面积
            double area = coveredWidth * diff;
            // 如果加上这部分面积超过总面积的一半
            if (2L * (currArea + area) >= totalArea) {
                return prevHeight + (totalArea - 2.0 * currArea) / (2.0 * coveredWidth);
            }
            // 更新宽度：开始事件加宽度，结束事件减宽度
            coveredWidth += delta * l;
            currArea += area;
            prevHeight = y;
        }

        return 0.0;
    }
}
