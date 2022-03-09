package huawei;

import java.util.Scanner;

public class HJ63 {

    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String max = "";
            double maxRatio = Integer.MIN_VALUE;
            int n = sc.nextInt();
            for(int i = 0;i <= str.length()-n;i++){
                String s = str.substring(i,i+n);
                if(s.equals("AGT") || s.equals("CT")) continue;
                double count = 0.00;
                for(char c : s.toCharArray()){
                    if(c == 'G' || c == 'C') count ++;
                }
                if(count/s.length() > maxRatio){
                    maxRatio = count/s.length();
                    max = s;
                }
            }
            System.out.println(max);
        }
    }
}
