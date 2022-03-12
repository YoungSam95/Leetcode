package huawei;

import java.util.Scanner;

/**
 * 如果一个数num>1，那么这个数的立方根一定在1~num之间。
 * 如果一个数num<-1，那么这个数的立方根一定在num~-1
 * 如果一个数-1<num<1，那么这个数的立方根一定在-1~1之间 如num = 2.7
 */

public class HJ107 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double n = sc.nextDouble();
            double res = 0;
            double right = Math.max(1.0,n);
            double left = Math.min(-1.0,n);
            double mid;
            while (right - left > 0.001) {
                mid = (left + right) / 2;
                //如果乘积大于num，说明立方根在mid的左侧
                if (mid * mid * mid > n) {
                    right = mid;
                }
                //如果乘积小于num，说明立方根在mid的右侧
                else if (mid * mid * mid < n) {
                    left = mid;
                } else {
                    res =  mid;
                    break;
                }
            }
            if(res ==0) res = right;
            System.out.printf("%.1f",res);
            System.out.println();
        }
    }
}
