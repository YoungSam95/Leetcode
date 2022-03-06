package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<Character,Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        int min = Integer.MAX_VALUE;
        for(int i : map.values()){
            min = Math.min(min,i);
        }
        StringBuilder builder = new StringBuilder();
        for(char c : str.toCharArray()){
            if(map.get(c) != min){
                builder.append(c);
            }
        }
        System.out.println(builder.toString());
    }
}
