package huawei;

import java.util.Scanner;

public class HJ37 {

    public static int count(int month){
        if(month < 3) return 1;
        return count(month - 1) + count(month -2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int month = sc.nextInt();
            System.out.println(count(month));
        }
    }
}
