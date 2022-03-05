package huawei;

import java.util.Scanner;

public class HJ1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] res = str.split(" ");
        System.out.println(res[res.length-1].length());
    }
}
