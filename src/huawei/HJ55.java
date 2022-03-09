package huawei;

import java.util.Scanner;

public class HJ55 {

    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int count = 0;
            for(int i = 7; i <= n; i++){
                if(i%7 == 0 || String.valueOf(i).contains("7")){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
