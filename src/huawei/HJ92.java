package huawei;

import java.util.*;

public class HJ92 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            List<String> res = new ArrayList<>();
            String str= sc.nextLine();
            int max = 0;
            int start = 0, end = 0;
            for(start = 0; start < str.length(); start++){
                if(Character.isDigit(str.charAt(start))){
                    for(end = start; end < str.length(); end++){
                        if(!Character.isDigit(str.charAt(end)) || end == str.length()-1){
                            if(end == str.length()-1){
                                res.add(str.substring(start,end+1));
                            }else {
                                res.add(str.substring(start, end));
                            }
                            start = end;
                            break;
                        }
                    }
                }
            }
            Collections.sort(res, (s1, s2) -> s2.length() - s1.length());
            StringBuilder sb = new StringBuilder();
            for(String s : res){
                if(s.length() == res.get(0).length()){
                    sb.append(s);
                }
            }
            sb.append("," + res.get(0).length());
            System.out.println(sb.toString());
        }
    }
}
