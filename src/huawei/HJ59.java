package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ59 {

    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            boolean flag = true;
            for(char c : str.toCharArray()){
                if(str.indexOf(c) == str.lastIndexOf(c)){
                    System.out.println(c);
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println(-1);
        }
    }
}
