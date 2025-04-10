package leetcode;

import java.util.Arrays;

/**
 * 2070. 每一个查询的最大美丽值
 */
public class Solution2070 {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // 将物品按价格升序排序
        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));
        int n = items.length;
        // 按定义修改美丽值
        for (int i = 1; i < n; ++i) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }
        // 二分查找处理查询
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = query(items, queries[i]);
        }
        return res;
    }

    private int query(int[][] items, int q) {
        int l = 0, r = items.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (items[mid][0] > q) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (l == 0) {
            // 此时所有物品价格均大于查询价格
            return 0;
        } else {
            // 返回小于等于查询价格的物品的最大美丽值
            return items[l - 1][1];
        }
    }
}
