/**
 * 5. 最长回文子串
 */

class Solution5 {
    public static String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++){
            //以s[i]为中心的回文子串
            String s1 = Palindrome(s,i,i);
            //以s[i][i+1]为中心的回文子串
            String s2 = Palindrome(s,i,i+1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }
    public static String Palindrome(String s, int l, int r){
        while(l >=0 && r <s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return s.substring(l + 1,r);
    }

    public static void main(String[] args){
        String s = "a";
        System.out.println(longestPalindrome(s));
    }
}
