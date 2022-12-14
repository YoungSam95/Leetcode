package leetcode;

/**
 * 1945. 字符串转化后的各位数字之和
 */
public class Solution1945 {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i) - 'a' + 1);
        }
        String num = sb.toString();
        for (int i = 0; i < k && num.length() > 1; i++) {
            int sum = 0;
            for(int j = 0; j < num.length(); j++) {
                sum += num.charAt(j) - '0';
            }
            num = Integer.toString(sum);
        }
        return Integer.parseInt(num);
    }
}
