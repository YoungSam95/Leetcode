package huawei;

import java.util.Scanner;

public class HJ34 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        for(int i = 0; i < chars.length-1; i++){
            for(int j = i + 1; j < chars.length; j++){
                if(chars[j] < chars [i]){
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        System.out.println(String.valueOf(chars));
    }
}
