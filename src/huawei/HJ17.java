package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ17{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while(sc.hasNext()) {
            String s = sc.nextLine();
            int x = 0 , y = 0;
            String[] sArray = s.split(";");
            String res = "[ADWS][0-9]{1,2}";
            for(int i = 0;i < sArray.length;i ++) {
                if(sArray[i].matches(res))
                    map.put(sArray[i].charAt(0),map.getOrDefault(sArray[i].charAt(0), 0)+Integer.valueOf(sArray[i].substring(1)));
            }
            x = x - map.get('A') + map.get('D');
            y = y - map.get('S') + map.get('W');
            System.out.println(x+","+y);
            map.clear();
        }
    }
}
