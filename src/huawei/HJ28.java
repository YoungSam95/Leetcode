package huawei;

import java.util.*;

public class HJ28 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            ArrayList<Integer> evens = new ArrayList();//偶数列
            ArrayList<Integer> odds = new ArrayList();//奇数列

            for (int i = 0; i < n; i++) {
                if ((arr[i] & 1) == 1) {
                    evens.add(arr[i]);
                } else {
                    odds.add(arr[i]);
                }
            }
            int[] evensMatch = new int[evens.size()];
            int count = 0;
            if(evens.size() == 0 || odds.size() == 0){
                count = 0;//奇+奇和偶+偶都不可能是素数
            }else {
                for (int i = 0; i < odds.size(); i++) {
                    int[] used = new int[evens.size()];
                    if (find(used, evens, odds.get(i), evensMatch))
                        count++;
                }
            }
            System.out.println(count);

        }
    }

    public static boolean isPrime(int m) {
        for (int i = 2; i * i <= m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean find(int[] used, ArrayList<Integer> evens, int num, int[] evensMatch) {
        for (int i = 0; i < evens.size(); i++) {
            if (isPrime(num + evens.get(i)) && used[i] == 0) {
                used[i] = 1;
                if (evensMatch[i] == 0 || find(used, evens, evensMatch[i], evensMatch)) {
                    evensMatch[i] = num;
                    return true;
                }
            }
        }
        return false;
    }
}
