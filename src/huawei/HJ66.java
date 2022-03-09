package huawei;

import java.util.*;

public class HJ66 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        map.put("reset","reset what");
        map.put("reset board","board fault");
        map.put("board add","where to add");
        map.put("reboot backplane","impossible");
        map.put("backplane abort","install first");
        map.put("board delete","no board at all");
        map.put("noMatch","unknown command");
        Set<String[]> set = new HashSet<>();
        for (String s: map.keySet()){
            set.add(s.split(" "));
        }

        while (sc.hasNext()){
            String[] arr = sc.nextLine().split(" ");
            String res = "noMatch";
            int count = 0;
            for (String[] s: set) {
                if (arr.length==1){
                    if (s.length==2)
                        continue;
                    else {
                        if (s[0].startsWith(arr[0]))
                            res = s[0];
                    }
                }
                if (arr.length==2){
                    if (s.length==1)
                        continue;
                    else{
                        if (s[0].startsWith(arr[0]) && s[1].startsWith(arr[1])) {
                            res = s[0] + " " + s[1];
                            count++;
                        }
                    }
                }
            }
            System.out.println(count>1? "unknown command":map.get(res));
        }
    }
}
