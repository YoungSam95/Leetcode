package huawei;

import java.util.Scanner;

public class HJ7 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        int res = (int)num;
        double  n = num - res;
        System.out.println(n < 0.5 ? res : ++res);
    }
}
