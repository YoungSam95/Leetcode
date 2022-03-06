package huawei;

import java.util.Scanner;

public class HJ60{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            for(int i=n/2;i>=2;i--){
                if(isPrime(i)&&isPrime(n-i)){
                    System.out.println(i);
                    System.out.println(n-i);
                    break;
                }
            }
        }
    }

    public static boolean isPrime(int n){
        for(int i=2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}

