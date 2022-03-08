package huawei;

import java.util.Scanner;

public class HJ33 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if(str.contains(".")){
                String[] strs = str.split("\\.");
                long result = 0;
                for(int i = 0;i < 4;i++){
                    result = result*256 + Integer.parseInt(strs[i]);
                }
                System.out.println(result);
            }else{
                long ip = Long.parseLong(str);
                String res = "";
                for(int i = 0; i < 4;i++){
                    res = ip % 256 + "." + res;
                    ip /=256;
                }
                System.out.println(res.substring(0,res.length()-1));
            }

        }
    }
}
