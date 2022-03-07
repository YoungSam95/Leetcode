package huawei;

import java.util.Scanner;

public class HJ91{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(paths(n,m));
        }
    }
    public static int paths(int n,int m){
        if(n == 0 || m == 0){
            return 1;
        }
        return paths(n-1,m) + paths(n,m-1);
    }
}
