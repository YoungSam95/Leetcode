package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class HJ45 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] names = new String[n];
            for(int i = 0; i < n;i++){
                names[i] = sc.next().toLowerCase();
            }
            for(String name : names){
                System.out.println(count(name));
            }
        }
    }

    public static int count(String name){
        int[] chars = new int[26];
        for(char c : name.toCharArray()){
            chars[c - 'a']++;
        }
        Arrays.sort(chars);
        int val = 26;
        int result = 0;
        for(int i = 25; i >= 0; i--){
            if(chars[i] != 0){
                result += chars[i]*val;
                val--;
            }
        }
        return result;
    }
}
