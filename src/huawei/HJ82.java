package huawei;

import java.util.Scanner;

/**
 数学家斐波那契提出的一种求解***分数的贪心算法，准确的算法表述应该是这样的：
 设某个真分数的分子为a，分母为b;
 把c=(b/a+1)作为分解式中第一个***分数的分母；
 将a-b%a作为新的a；
 将b*c作为新的b；
 如果a等于1，则最后一个***分数为1/b,算法结束；
 如果a大于1但是a能整除b，则最后一个***分数为1/(b/a),算法结束；
 否则重复上面的步骤。
 **/

public class HJ82 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String res = "";
            String[] arr = sc.nextLine().split("/");
            String pre = "";
            long a = Long.valueOf(arr[0]);
            long b = Long.valueOf(arr[1]);
            while (true){
                Long c = b/a+1;
                res += "1/";
                res += c;
                a = a - b % a;
                b = b * c;
                res += "+";
                if (a == 1){
                    res += "1/";
                    res += b;
                    break;
                }else if (a > 1 && b % a == 0){
                    res += "1/";
                    res += b/a;
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
