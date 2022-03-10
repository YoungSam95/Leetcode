package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ74 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int index = 0;
            List<String> res = new ArrayList<>();
            while(index < str.length()){
                if(str.charAt(index) != '"'){
                    if(str.charAt(index) == ' ') index++;
                    StringBuilder builder = new StringBuilder();
                    while(index < str.length() && str.charAt(index) != ' '){
                        builder.append(str.charAt(index));
                        index++;
                    }
                    res.add(builder.toString());
                    index++;
                }else{
                    index++;
                    StringBuilder builder = new StringBuilder();
                    while(index < str.length() && str.charAt(index) != '"'){
                        builder.append(str.charAt(index));
                        index++;
                    }
                    res.add(builder.toString());
                    index++;
                }
            }
            System.out.println(res.size());
            for(String s : res){
                System.out.println(s);
            }
        }
    }
}
