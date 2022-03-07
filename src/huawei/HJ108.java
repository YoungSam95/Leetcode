package huawei;

import java.util.Scanner;

public class HJ108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = 2;
            int max = Math.max(a,b);
            int res = Math.max(a,b);
            while(!(res%a == 0 && res%b ==0)){
                res = max*c;
                c++;
            }
            System.out.println(res);
        }
    }
}
