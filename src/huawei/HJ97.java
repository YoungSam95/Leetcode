package huawei;

import java.util.Scanner;

public class HJ97 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int count = 0;
            int minus = 0;
            int positiv = 0;
            for(int i = 0; i < n; i++){
                int num = sc.nextInt();
                if(num < 0){
                    minus++;
                }else if(num > 0){
                    count += num;
                    positiv++;
                }
            }
            System.out.println(minus + " " + String.format("%.1f", count * 1.0 / positiv));
        }
    }
}
