package huawei;

import java.util.Scanner;

public class HJ96 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < str.length(); ) {
                // 若发现了数字
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    res.append('*');
                    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                        res.append(str.charAt(i++));
                    }
                    res.append('*');
                } else {
                    res.append(str.charAt(i++));
                }
            }
            System.out.println(res.toString());
        }
    }
}
