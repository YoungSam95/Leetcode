package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HJ27 {

    public static boolean checkBrother(String str1,String str2){
        int[] arr = new int[26];
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for(int i=0; i<ch1.length; i++){
            arr[ch1[i]-'a']++;
            arr[ch2[i]-'a']--;
        }
        for(int i=0; i<26; i++){
            if(arr[i]!=0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] strs = new String[n];
            for(int i =0; i < n; i++){
                strs[i] = sc.next();
            }
            String str = sc.next();
            int k = sc.nextInt();
            List<String> list = new ArrayList<>();
            for(String s : strs){
                if(s.length() == str.length() && !s.equals(str)){
                    if(checkBrother(s,str)){
                        list.add(s);
                    }
                }
            }
            Collections.sort(list);
            System.out.println(list.size());
            if(list.size() >= k){
                System.out.println(list.get(k-1));
            }
        }
    }
}
