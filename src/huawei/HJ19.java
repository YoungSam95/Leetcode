package huawei;

import java.util.*;

public class HJ19 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String file = line.split(" ")[0];
            String where = line.split(" ")[1];
            String subFile = "";
            int index = file.lastIndexOf("\\");
            if(file.substring(index+1).length() > 16){
                subFile = file.substring(file.length() - 16) + " " + where;
            }else{
                subFile = file.substring(index+1) + " " + where;
            }
            map.put(subFile,map.getOrDefault(subFile,0)+1);
            if(!list.contains(subFile)) {
                list.add(subFile);
            }
        }

        for(int i =list.size()>8? list.size()-8:0; i < list.size(); i++){
            System.out.println(list.get(i) + " " + map.get(list.get(i)));
        }
    }
}
