package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1840. 最高建筑高度
 */
public class Solution1840 {
    public int maxBuilding(int n, int[][] restrictions) {
        // 将限制转换为列表以便操作
        List<int[]> r = new ArrayList<>();
        for (int[] res : restrictions) {
            r.add(new int[]{res[0], res[1]});
        }

        // 增加限制 (1, 0)
        r.add(new int[]{1, 0});
        // 按位置排序
        r.sort((a, b) -> Integer.compare(a[0], b[0]));
        // 增加限制 (n, n-1)
        if (r.get(r.size() - 1)[0] != n) {
            r.add(new int[]{n, n - 1});
        }

        int m = r.size();

        // 从左向右传递限制
        for (int i = 1; i < m; ++i) {
            int dist = r.get(i)[0] - r.get(i - 1)[0];
            r.get(i)[1] = Math.min(r.get(i)[1], r.get(i - 1)[1] + dist);
        }

        // 从右向左传递限制
        for (int i = m - 2; i >= 0; --i) {
            int dist = r.get(i + 1)[0] - r.get(i)[0];
            r.get(i)[1] = Math.min(r.get(i)[1], r.get(i + 1)[1] + dist);
        }

        int ans = 0;
        for (int i = 0; i < m - 1; ++i) {
            // 计算 r[i][0] 和 r[i][1] 之间的建筑的最大高度
            int dist = r.get(i + 1)[0] - r.get(i)[0];
            int best = (dist + r.get(i)[1] + r.get(i + 1)[1]) / 2;
            ans = Math.max(ans, best);
        }

        return ans;
    }
}
