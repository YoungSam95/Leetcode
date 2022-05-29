package leetcode;

/**
 * 468. 验证IP地址
 */
public class Solution468 {
    public String validIPAddress(String queryIP) {
        if (queryIP.indexOf('.') >= 0) {
            return isValidIPv4(queryIP);
        } else {
            return isValidIPv6(queryIP);
        }
    }

    public String isValidIPv6(String queryIP) {
        int last = -1;
        for (int i = 0; i < 8; ++i) {
            int cur = (i == 7 ? queryIP.length() : queryIP.indexOf(':', last + 1));
            if (cur < 0) {
                return "Neither";
            }
            if (cur - last - 1 < 1 || cur - last - 1 > 4) {
                return "Neither";
            }
            for (int j = last + 1; j < cur; ++j) {
                if (!Character.isDigit(queryIP.charAt(j)) && !('a' <= Character.toLowerCase(queryIP.charAt(j)) && Character.toLowerCase(queryIP.charAt(j)) <= 'f')) {
                    return "Neither";
                }
            }
            last = cur;
        }
        return "IPv6";
    }

    public String isValidIPv4(String queryIP) {
        int last = -1;
        for (int i = 0; i < 4; ++i) {
            int cur = (i == 3 ? queryIP.length() : queryIP.indexOf('.', last + 1));
            if (cur < 0) {
                return "Neither";
            }
            if (cur - last - 1 < 1 || cur - last - 1 > 3) {
                return "Neither";
            }
            int addr = 0;
            for (int j = last + 1; j < cur; ++j) {
                if (!Character.isDigit(queryIP.charAt(j))) {
                    return "Neither";
                }
                addr = addr * 10 + (queryIP.charAt(j) - '0');
            }
            if (addr > 255) {
                return "Neither";
            }
            if (addr > 0 && queryIP.charAt(last + 1) == '0') {
                return "Neither";
            }
            if (addr == 0 && cur - last - 1 > 1) {
                return "Neither";
            }
            last = cur;
        }
        return "IPv4";
    }
    public static void main(String[] args){
        String queryIP = "172.16.254.1.";
        Solution468 solution = new Solution468();
        System.out.println(solution.validIPAddress(queryIP));
    }
}
