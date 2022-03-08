package huawei;

import java.util.Scanner;

/**
 * dp[i][j]：A[0--i-1]和B[0--j-1]的编辑距离，所求结果为dp[A.length()][B.length()];
 * A[0,...i-1]最后修改为B[0,...j-1]，有以下两种情况：
 * （一）A[i-1] == B[j-1]时，最后一个元素不用动，只用考虑A[0,...i-2]编辑为B[0,...j-2]需要的代价,dp[i][j] = dp[i-1][j-1]
 * （二）A[i-1]!=B[j-1]时，又可以分成以下三种情况：
 *      1、从A[0,...i-2]编辑为B[0,...j-1]，再删除A[i-1]
 *      2、从A[0,...i-1]编辑为B[0,...j-2]，再插入B[j-1]
 *      3、从A[0,...i-2]编辑为B[0,...j-2]，再将A[i-1]修改为B[j-1]
 */

public class HJ52 {

    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int dp[][] = new int[s1.length()+1][s2.length()+1];
            dp[0][0] = 0;
            for(int i = 1;i<dp.length;i++){
                dp[i][0] = i;
            }
            for(int i = 1;i<dp[0].length;i++){
                dp[0][i] = i;
            }
            for(int i = 1;i<dp.length;i++){
                for(int j = 1;j<dp[0].length;j++){
                    if(s1.charAt(i-1)==s2.charAt(j-1))
                    {
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else {
                        dp[i][j] = Math.min(dp[i-1][j-1]+1,Math.min(dp[i][j-1]+1,dp[i-1][j]+1));
                    }
                }
            }
            System.out.println(dp[s1.length()][s2.length()]);
        }
    }
}
