package others; /**
 * 问题描述：计程车价钱每位数遇到4跳过，根据现实的价钱求出真实的价钱
 */

import java.util.Arrays;
import java.util.Scanner;

public class Realprice {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int num=cin.nextInt();
        int co;//余数，记录每一位
        int sum=0;
        int h=1;
        //作为9进制计算
        while (num>0)
        {
            co=num%10;
            num=num/10;

            if(co<4)
                sum=sum+co*h;
            else
                sum=sum+(co-1)*h;

            h=h*9;
        }
        System.out.println(sum);
    }
}
