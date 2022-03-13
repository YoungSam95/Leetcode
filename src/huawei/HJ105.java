package huawei;

import java.util.Scanner;

public class HJ105 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float sum = 0;
        int countP = 0;
        int countN = 0;
        int num = 0;
        while (sc.hasNextInt()) {
            num = sc.nextInt();
            if(num >= 0){
                sum +=num;
                countP++;
            }else{
                countN++;
            }
        }
        System.out.println(countN);
        if(countP > 0){
            System.out.printf("%.1f\n",sum/countP);
        }else{
            System.out.println("0.0");
        }
    }
}
