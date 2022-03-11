package huawei;

import java.util.Scanner;

public class HJ90 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split("\\.");
            boolean flag = true;
            if (s.length == 4) {
                for (String s1 : s) {
                    if(s1.equals("")){
                        flag = false;
                        break;
                    }
                    if(s1.startsWith("0") && s1.length()>1){
                        flag = false;
                        break;
                    }
                    if(!Character.isDigit(s1.charAt(0))){
                        flag = false;
                        break;
                    }
                    try {
                        int i = Integer.parseInt(s1);
                        if(i < 0 || i > 255){
                            flag = false;
                            break;
                        }
                    } catch (NumberFormatException err) {
                        flag = false;
                        break;
                    }
                }
            }else{
                flag = false;
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}
