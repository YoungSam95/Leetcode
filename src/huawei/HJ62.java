package huawei;

import java.util.Scanner;

public class HJ62 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while (sc.hasNextInt()){
            int num = sc.nextInt();
            while(num/2 != 0){
                if(num%2 == 1) count++;
                num = num/2;
            }
            System.out.println(++count);
            count = 0;
        }
    }
}
