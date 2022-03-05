package huawei;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class HJ3 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        TreeSet set = new TreeSet();
        for(int i = 0;i < num;i++){
            set.add(scanner.nextInt());
        }
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
