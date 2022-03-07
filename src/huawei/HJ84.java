package huawei;

import java.util.Scanner;

public class HJ84 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String res = str.replaceAll("[^A-Z]","");
            System.out.println(res.length());
        }
    }
}
