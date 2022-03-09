package huawei;

import java.util.Scanner;

public class HJ65 {

    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(longString(s1,s2));
        }
    }

    private static String longString(String s1, String s2) {
        if(s1.length() > s2.length()){
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }
        int m = s1.length() + 1;
        int n = s2.length() + 1;
        int[][] dp = new int[m][n];
        int max = 0;
        int index = 0;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n;j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if(dp[i][j] > max){
                        max = dp[i][j];
                        index = i;
                    }
                }
            }
        }
        return s1.substring(index - max,index);
    }
}
