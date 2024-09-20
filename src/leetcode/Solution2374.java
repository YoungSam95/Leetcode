package leetcode;

/**
 * 2374. 边积分最高的节点
 */
public class Solution2374 {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] points = new long[n];
        for (int i = 0; i < n; i++) {
            points[edges[i]] += i;
        }
        long maxPoints = -1;
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (points[i] > maxPoints) {
                maxPoints = points[i];
                res = i;
            }
        }
        return res;
    }
}
