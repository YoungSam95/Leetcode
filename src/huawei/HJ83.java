package huawei;

import java.util.Scanner;

public class HJ83 {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int m = sc.nextInt(); //行
            int n = sc.nextInt(); //列
            System.out.println(0);

            int x1,y1,x2,y2;
            int flag1 = -1;
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            if(x1 >= 0 && x1 < m &&
                    y1 >= 0 && y1 < n &&
                    x2 >= 0 && x2 < m &&
                    y2 >= 0 && y2 < n){
                flag1 = 0;
            }
            System.out.println(flag1);

            int lin = sc.nextInt();
            int flag2 = -1;
            //没有这行返回0
            if(lin < m && lin >= 0){
                flag2 = 0;
            }
            else{
                flag2 = -1;
            }
            //达到上限返回0
            if(m == 9){
                flag2 = -1;
            }
            System.out.println(flag2);

            int col = sc.nextInt();
            int flag3 = -1;
            //没有这列返回0
            if(col < n && col >= 0){
                flag3 = 0;
            }
            else{
                flag3 = -1;
            }
            //达到上限返回0
            if(n == 9){
                flag3 = -1;
            }
            System.out.println(flag3);

            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x >= 0 && x < m &&
                    y >= 0 && y < n){
                System.out.println(0);
            }else{
                System.out.println(-1);
            }

        }
    }
}
