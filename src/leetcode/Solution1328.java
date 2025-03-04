package leetcode;

/**
 * 1328. 破坏回文串
 */
public class Solution1328 {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) {
            return "";
        }
        char[] data = palindrome.toCharArray();
        for (int i = 0; i * 2 + 1 < n; i++) {
            if (data[i] != 'a') {
                data[i] = 'a';
                return new String(data);
            }
        }
        data[n - 1] = 'b';
        return new String(data);
    }
}
