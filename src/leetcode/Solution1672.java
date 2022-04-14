package leetcode;

/**
 * 1672. 最富有客户的资产总量
 */
public class Solution1672 {

    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int i = 0; i < accounts.length; i++){
            int count = 0;
            for(int j = 0; j < accounts[i].length; j++){
                count += accounts[i][j];
            }
            max = Math.max(max,count);
        }
        return max;
    }
}
