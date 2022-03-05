package huawei;

import java.util.Scanner;

public class HJ5 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().substring(2);
        String res = Integer.valueOf(str,16).toString();
        System.out.println(res);
    }
}
