package huawei;

import java.util.Scanner;

public class HJ100 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(n*2 + (n*(n-1)/2)*3);
        }
    }
}
