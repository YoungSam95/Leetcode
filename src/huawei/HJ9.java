package huawei;

import java.util.Scanner;

public class HJ9 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String str = String.valueOf(num);
        String res = "";
        char[] cs = str.toCharArray();
        for(int i = cs.length - 1; i >= 0; i--){
            if(!res.contains(cs[i]+"")){
                res += cs[i];
            }
        }
        System.out.println(Integer.valueOf(res));
    }
}
