package huawei;

import java.util.Scanner;

public class HJ85 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String res = "";
        for(int i = 0; i < s.length(); i++){
            //以s[i]为中心的回文子串
            String s1 = Palindrome(s,i,i);
            //以s[i][i+1]为中心的回文子串
            String s2 = Palindrome(s,i,i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        System.out.println(res.length());

    }
    public static String Palindrome(String s, int l, int r){
        while(l >=0 && r <s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l + 1,r);
    }
}
