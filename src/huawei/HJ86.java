package huawei;

import java.util.Scanner;

public class HJ86 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int num = sc.nextInt();
            int count = 0;
            int max = 1;
            while(num != 0){
                if(num%2 == 1){
                    count++;
                }else{
                    max = Math.max(max,count);
                    count = 0;
                }
                num = num/2;
            }
            max = Math.max(max,count);
            System.out.println(max);
        }
    }
}
