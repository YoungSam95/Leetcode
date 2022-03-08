package huawei;

import java.util.Scanner;

public class HJ24 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] arr1 = new int[n]; //存储每个数左边小于其的数的个数
            int[] arr2 = new int[n];//存储每个数右边小于其的数的个数
            arr1[0] = 1;            //最左边的数设为1
            arr2[n - 1] = 1;        //最右边的数设为1
            for (int i = 0; i < n; i++) {
                arr1[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {   //动态规划
                        arr1[i] = Math.max(arr1[j] + 1, arr1[i]);
                    }
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                arr2[i] = 1;
                for (int j = n - 1; j > i; j--) {
                    if (arr[i] > arr[j]) {   //动态规划
                        arr2[i] = Math.max(arr2[i], arr2[j] + 1);
                    }
                }
            }
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = arr1[i] + arr2[i] - 1; //两个都包含本身
            }

            int max = 1;
            for (int i = 0; i < n; i++) {
                if (res[i] > max) {
                    max = res[i];
                }
            }
            System.out.println(n - max);
        }

    }
}
