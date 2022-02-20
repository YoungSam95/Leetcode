package leetcode; /**
 * 93. 复原 IP 地址
 *    给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 *    有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 解题思路：
 *    回溯法 递归
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution93 {

    public static List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4) {//如果s长度大于12或者小于4 则不能组成ip地址，返回空
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>(); //用于存储最终答案
        ArrayList<String> ip = new ArrayList<>();//用于存储临时ip地址
        for (int i = 0; i < 4; i++) {
            ip.add("");
        }
        p(res, s.toCharArray(), 0, ip, 0);

        return res;
    }

    private static void p(List<String> res, char[] chars, int startIndex, List<String> ip, int segmentIndex) {
        StringBuilder  builder = new StringBuilder();
        //String ipStr = "";
        for (int i = startIndex; i < chars.length; i++) {
            builder.append(chars[i]);
            String ipStr = builder.toString();
            //ipStr = ipStr+chars[i]+"";
            int parseInt = Integer.parseInt(ipStr);
            if (parseInt > 255) { //如果大于255 不满足 回溯
                return;
            }
            if (ipStr.length() > 1 && ipStr.startsWith("0")) { //如果以0开头且不是0 不满足 回溯
                return;
            }

            ip.set(segmentIndex, ipStr);
            if (segmentIndex == 3 && i == chars.length - 1) { //找到满足的IP地址并且用完所有字符 返回最终结果
                res.add(String.join(".", ip));
            }

            if (segmentIndex < 3) {
                p(res, chars, i + 1, ip, segmentIndex + 1);
            }
        }

    }

    public static void main (String[]args){
        String s = "101023";
        List<String> res = restoreIpAddresses(s);
        System.out.println(res.toString());
    }
}
