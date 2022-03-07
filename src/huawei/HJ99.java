package huawei;

import java.util.Scanner;

public class HJ99 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int count = 0;
            for(int i = 0;i <=num;i++){
                String str1 = String.valueOf(i);
                String str2 = String.valueOf(i*i);
                if(str1.equals(str2.substring(str2.length()-str1.length(),str2.length()))){
                    count++;
                }
            }
            System.out.println(count);

        }
    }
}
