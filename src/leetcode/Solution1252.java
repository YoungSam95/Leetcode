package leetcode;

/**
 * 1252. 奇数值单元格的数目
 */
public class Solution1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int res = 0;
        int[] row = new int[m];
        int[] col = new int[n];
        for(int[] in : indices){
            row[in[0]]++;
            col[in[1]]++;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if((row[i] + col[j]) % 2 != 0) res++;
            }
        }
        return res;
    }
}
