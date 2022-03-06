package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ40 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.nextLine();
            Map<String,Integer> map = new HashMap<>();
            map.put("character",0);
            map.put("number",0);
            map.put("space",0);
            map.put("others",0);
            for(char c : str.toCharArray()){
                if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                    map.put("character",map.getOrDefault("character",0) + 1);
                }else if(c >= 48 && c <= 57){
                    map.put("number",map.getOrDefault("number",0) + 1);
                }else if(c == ' '){
                    map.put("space",map.getOrDefault("space",0) + 1);
                }else{
                    map.put("others",map.getOrDefault("others",0) + 1);
                }
            }
            System.out.println(map.get("character"));
            System.out.println(map.get("space"));
            System.out.println(map.get("number"));
            System.out.println(map.get("others"));
        }
    }
}
