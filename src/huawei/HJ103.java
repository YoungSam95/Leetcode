package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class HJ103 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            int[] dp = new int[n];
            Arrays.fill(dp,1);
            for(int i = 0; i < n;i++){
                for(int j = 0; j < i;j++){
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int max = 0;
            for(int i = 0; i < n;i++){
                max = Math.max(max,dp[i]);
            }
            System.out.println(max);
        }
    }
}
