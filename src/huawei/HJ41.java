package huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ41 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] weight = new int[n];
            int[] num = new int[n];
            for(int i = 0; i < n;i++){
                weight[i] = sc.nextInt();
            }
            for(int i = 0; i < n;i++){
                num[i] = sc.nextInt();
            }
            Set<Integer> set = new HashSet<>();
            set.add(0);
            for(int i=0;i<n;i++){//遍历砝码
                ArrayList<Integer> list = new ArrayList<>(set);//取当前所有的结果
                for(int j=1;j<=num[i];j++){//遍历个数
                    for(int k=0;k<list.size();k++){
                        set.add(list.get(k) + weight[i] * j);
                    }
                }
            }
            System.out.println(set.size());
        }
    }
}
