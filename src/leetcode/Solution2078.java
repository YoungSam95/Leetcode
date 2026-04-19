package leetcode;

/**
 * 2078. 两栋颜色不同且距离最远的房子
 */
public class Solution2078 {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int res = 0;   // 两栋颜色不同房子的最远距离
        // 遍历两栋房子下标并维护最远距离
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (colors[i] != colors[j]) {
                    res = Math.max(res, j - i);
                }
            }
        }
        return res;
    }
}
