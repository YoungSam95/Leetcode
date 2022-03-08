package huawei;

import java.util.Scanner;

public class HJ38 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            double sum = 0;
            double high = n;
            for(int i = 0; i < 5;i++){
                sum += high*2;
                high /= 2;
            }
            sum -= n;
            System.out.printf("%.6f\n",sum);
            System.out.printf("%.6f\n",high);
        }
    }
}
