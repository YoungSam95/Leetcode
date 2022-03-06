package huawei;

import java.util.Scanner;

public class HJ31 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        /*String[] strs = str.split("[^a-zA-Z]");
        for(int i = strs.length-1; i >= 0; i--){
            System.out.print(strs[i] + " ");
        }*/
        StringBuilder builder = new StringBuilder();
        for(char c : str.toCharArray()){
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                builder.append(c);
            }else{
                builder.append(' ');
            }
        }
        String res = builder.toString();
        String[] ress = res.split(" ");
        for(int i = ress.length-1; i >= 0; i--){
            System.out.print(ress[i] + " ");
        }
    }
}
