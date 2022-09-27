package huawei;

/**
 * 2022/9/27面试
 */

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static int minTime(int[] level, int n, int k){
        Arrays.sort(level);
        int time = 0;
        for(int i = n - 1; i >=0;){
            if(i - k <= 0){
                time += level[i] - 1;
                break;
            }else{
                time += (level[i] - 1) * 2;
            }
            i -= k;
        }
        return time;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] level = new int[n];
        for(int i = 0; i < n; i++){
            level[i] = sc.nextInt();
        }
        System.out.println(minTime(level,n,k));
    }
}
