package huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ81 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String shortStr = sc.nextLine();
            String longStr = sc.nextLine();
            System.out.println(isContained(shortStr, longStr));
        }
    }

    public static boolean isContained(String shortStr, String longStr) {
        Set<Character> set = new HashSet<>();
        for(char c : longStr.toCharArray()){
            set.add(c);
        }
        for(char c : shortStr.toCharArray()){
            if(!set.contains(c)) return false;
        }
        return true;
    }
}
