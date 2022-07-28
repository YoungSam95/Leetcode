package leetcode;

import java.util.Arrays;

/**
 * 593. 有效的正方形
 */
public class Solution593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        // 所有可能的边长，包括四条邻边和两条对角线
        int[] edge = {
                dis(p1, p2),
                dis(p1, p3),
                dis(p1, p4),
                dis(p2, p3),
                dis(p2, p4),
                dis(p3, p4)
        };
        Arrays.sort(edge);
        // 四邻边相等且大于0，两对角线相等
        return edge[0] > 0 && edge[0] == edge[1] && edge[0] == edge[2] && edge[0] == edge[3] &&
                edge[4] == edge[5];
    }

    public int dis(int[] p1, int[] p2) {
        // 求 (p1,p2) 的欧氏距离的平方
        int dx = p1[0] - p2[0];
        int dy = p1[1] - p2[1];
        return dx * dx + dy * dy;
    }
}
