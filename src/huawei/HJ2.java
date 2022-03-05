package huawei;

import java.util.Scanner;

public class HJ2 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        char ch = scanner.nextLine().charAt(0);
        ch = Character.toLowerCase(ch);
        int count = 0;
        for(int i = 0; i < str.length();i++){
            if(str.charAt(i) == ch){
                count++;
            }
        }
        System.out.println(count);
    }
}
