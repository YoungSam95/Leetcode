package huawei;

import java.util.Scanner;

public class HJ75 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String sStr = "";
            String lStr = "";
            if(str1.length() != str2.length()){
                sStr = str1.length() < str2.length() ? str1 : str2;
                lStr = str1.length() > str2.length() ? str1 : str2;
            }else{
                sStr = str1;
                lStr = str2;
            }

            int max = 0;
            for(int i = 0; i < sStr.length(); i++){
                for(int j = sStr.length(); j > i; j--){
                    if(lStr.contains(sStr.substring(i,j))){
                        max = Math.max(max,sStr.substring(i,j).length());
                        break;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
