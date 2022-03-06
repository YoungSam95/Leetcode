package huawei;

import java.util.Scanner;

public class HJ22 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            if(n == 0){
                sc.close();
                break;
            }
            int res = 0;
            while(n/3 != 0){
                res += n/3;
                n = n/3 + n%3;
            }
            if(n%3 == 2) res++;
            System.out.println(res);
        }
    }
}
