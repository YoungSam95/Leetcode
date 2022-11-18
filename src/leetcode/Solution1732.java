package leetcode;

/**
 * 1732. 找到最高海拔
 */
public class Solution1732 {
    public int largestAltitude(int[] gain) {
        int res = 0, high = 0;
        for(int i = 0; i < gain.length; i++){
            high += gain[i];
            res = Math.max(res,high);
        }
        return res;
    }
}
