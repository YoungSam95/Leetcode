package huawei;

/**
 * dp[i][j] 表示字符串 str的前i个字符和正则表达式的前j个字符是否能匹配
 *            dp[i-1][j-1]               case:str[i] == regx[j] || regx[j] == '?'
 * dp[i][j] = dp[i-1][j] || dp[i][j-1]   case:regx[j] == '*'
 *            false                      case:其他情况
 * dp[m][n]即是是否匹配的值
 */

import java.util.Scanner;

public class HJ71 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            boolean flag = true;
            String regx = sc.nextLine().toLowerCase();
            String str = sc.nextLine().toLowerCase();
            int m = str.length();
            int n = regx.length();
            //因为*和？只匹配数字和字母，这里排除一下str含有其他字符的情况，直接false
            for(char c : str.toCharArray()){
                if(!((c>='0' && c <='9') || (c>='a'&&c<='z') || c == '.')){
                    flag = false;
                    break;
                }
            }
            boolean[][] dp = new boolean[m+1][n+1];
            dp[0][0] = true;
            for (int i = 1; i <= n; ++i) {
                if (regx.charAt(i - 1) == '*') {
                    dp[0][i] = true;
                } else {
                    break;
                }
            }
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (regx.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else if (regx.charAt(j - 1) == '?' || str.charAt(i - 1) == regx.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            System.out.println(dp[m][n] && flag);
        }
    }

}
