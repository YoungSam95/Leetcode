package huawei;

import java.util.Scanner;

public class HJ95 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double rmb = sc.nextDouble();
            printMoney(rmb);
        }
    }

    private static void printMoney(double rmb) {
        String str = String.format("%.2f", rmb) + "";
        String[] gw = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] unit = {"", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "万", "拾", "佰", "仟", "万"};
        String[] tmp = str.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = tmp[0].length() - 1; i < tmp[0].length(); i++, j--) {
            if (tmp[0].charAt(i) != '0') {
                if (!(tmp[0].charAt(i) == '1' && "拾".equals(unit[j]))) {//用于排除10读成壹拾的情况
                    sb.append(gw[tmp[0].charAt(i) - '0']);
                }
                sb.append(unit[j]);
            } else {
                while (i < tmp[0].length() && tmp[0].charAt(i) == '0') {
                    if ("万".equals(unit[j]) || "亿".equals(unit[j])) {
                        sb.append(unit[j]);
                    }
                    i++;
                    j--;
                }
                if (i == tmp[0].length()) {
                    break;
                }
                if (j % 4 != 3) {
                    sb.append("零");
                }
                i--;
                j++;
            }
        }
        if (sb.length() != 0) {
            if ("00".equals(tmp[1])) {
                sb.append("元整");
            } else {
                sb.append("元");
            }
        }
        if (!"00".equals(tmp[1])) {
            for (int i = 0; i < 2; i++) {
                if (tmp[1].charAt(i) != '0' && i == 0) {
                    sb.append(gw[tmp[1].charAt(i) - '0']).append("角");
                }
                if (tmp[1].charAt(i) != '0' && i == 1) {
                    sb.append(gw[tmp[1].charAt(i) - '0']).append("分");
                }
            }
        }
        System.out.println("人民币" + sb.toString());
    }
}
