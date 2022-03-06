package huawei;

import java.util.Scanner;

public class HJ72 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            int money = (num/num)*100;
            for(int i = 0; i <= money/5;i++){
                for(int j = 0; j <= (money-i*5)/3; j++){
                    for(int k = 0; k <= (money-i*5-j*3)*3;k++){
                        if(5*i+3*j+k/3 == money && i+j+k == 100){
                            System.out.println(i + " " + j + " " + k);
                        }
                    }
                }
            }
        }
    }
}
