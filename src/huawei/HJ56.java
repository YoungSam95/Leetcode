package huawei;

import java.util.Scanner;

public class HJ56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int count = 0;
            int plus = 0;
            for(int i = 6; i <= num; i++){
                for(int j = 1; j < i; j++){
                    if(i%j != 0) continue;
                    plus += j;
                }
                if(plus == i) count++;
                plus = 0;
            }
            System.out.println(count);
        }
    }
}
