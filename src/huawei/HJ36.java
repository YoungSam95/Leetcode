package huawei;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class HJ36 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String key = sc.nextLine().toUpperCase();
            String mes = sc.nextLine();
            LinkedHashSet<Character> set = new LinkedHashSet<>();

            for(char c : key.toCharArray()){
                set.add(c);
            }
            int k = 0;
            while(set.size() < 26){
                char cr = (char)('A' + k);
                set.add(cr);
                k++;
            }

            ArrayList<Character> list = new ArrayList<>(set);
            StringBuffer sb = new StringBuffer();
            for(char c : mes.toCharArray()){
                if (c == ' ') {
                    sb.append(c);
                } else if (c < 'a') {
                    int n = (int) (c - 'A');
                    char cr = list.get(n);
                    sb.append(cr);
                } else {
                    int n = (int) (c - 'a');
                    char cr = (char)(list.get(n)+'a'-'A');
                    sb.append(cr);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
