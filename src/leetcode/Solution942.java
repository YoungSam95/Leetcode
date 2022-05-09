package leetcode;

/**
 * 942. 增减字符串匹配
 * 思路：贪心算法
 *      对于'I'每次都选取剩余数字中最小的，对于'D'每次都选取剩余数字中最大的；
 */
public class Solution942 {
    public int[] diStringMatch(String s) {
        int n = s.length(), currMin = 0, currMax = n;
        int[] perm = new int[n + 1];
        for(int i = 0; i < n; i++){
            perm[i] = s.charAt(i) == 'I' ? currMin++ : currMax--;
        }
        perm[n] = currMin;
        return perm;
    }
}
