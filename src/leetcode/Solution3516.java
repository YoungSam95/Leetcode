package leetcode;

/**
 * 3516. 找到最近的人
 */
public class Solution3516 {
    public int findClosest(int x, int y, int z) {
        int dxz = Math.abs(x - z), dyz = Math.abs(y - z);
        if (dxz < dyz) {
            return 1;
        } else if (dxz > dyz) {
            return 2;
        } else {
            return 0;
        }
    }
}
