package huawei;

import java.util.*;

public class HJ21{
    public static void main(String[] arg){
        HashMap<String,Integer> map=new HashMap<>();
        map.put("abc",2);
        map.put("def",3);
        map.put("ghi",4);
        map.put("jkl",5);
        map.put("mno",6);
        map.put("pqrs",7);
        map.put("tuv",8);
        map.put("wxyz",9);
        Scanner sc=new Scanner(System.in);
        String line=sc.next();
        for(char c:line.toCharArray()){
            if(c>='A'&&c<='Z'){
                if((c+32)=='z'){
                    System.out.print('a');
                }else{
                    System.out.print((char)(c+33));
                }
            }else if(c>='a'&&c<='z'){
                final Character cF=c;
                String key= map.keySet().stream().filter(o->o.contains(cF.toString())).findAny().get();
                System.out.print(map.get(key));
            }else{
                System.out.print(c);
            }
        }
    }
}
