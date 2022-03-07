package huawei;

import java.util.*;

public class HJ102 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            HashMap<Character,Integer> map=new HashMap<>();
            for(int i=0;i<str.length();i++){
                map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);//统计字符出现次数
            }
            ArrayList<Map.Entry> list=new ArrayList<>(map.entrySet());//把map放入list中。
            Collections.sort(list, new Comparator<Map.Entry>() {
                @Override
                public int compare(Map.Entry o1, Map.Entry o2) {
                    if(o1.getValue()!=o2.getValue()){//若次数不同
                        return (int)(o2.getValue())-(int)(o1.getValue());//一定记得转换类型，否则报错Object不能使用'-'运算符。
                    }else{//若次数相同
                        return (char)(o1.getKey())-(char)(o2.getKey());
                    }
                }
            });
            //打印key
            for (Map.Entry entry : list) {
                System.out.print(entry.getKey());
            }
            System.out.println();//打印完一组换行
        }
    }
}
