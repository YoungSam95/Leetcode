package huawei;

import java.util.Scanner;

public class HJ106 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] strs = sc.nextLine().split(" ");
            StringBuilder builder = new StringBuilder();
            for(int i = strs.length-1; i >=0;i--){
                for(int j = strs[i].length()-1; j>=0;j--){
                    builder.append(strs[i].charAt(j));
                }
                builder.append(" ");
            }
            System.out.println(builder.toString().trim());

        }
    }
}
