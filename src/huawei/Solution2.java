package huawei;

import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int x = 0;
            int y = 0;
            int res = 0;
            int n = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < n; i++){
                int currX = sc.nextInt();
                int offsetY = sc.nextInt();
                res += (currX - x) * Math.abs(y);
                x = currX;
                y = y + offsetY;
            }
            res += (E - x) * Math.abs(y);
            System.out.println(res);
        }
    }
}
