package huawei;

import java.util.HashSet;
import java.util.Scanner;

public class HJ10 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        HashSet<Integer> set = new HashSet<>();
        for(char c : str.toCharArray()){
            int i = c;
            if(!set.contains(i)){
                set.add(i);
            }
        }
        System.out.println(set.size());
    }
}
