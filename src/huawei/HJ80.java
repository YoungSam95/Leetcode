package huawei;

import java.util.*;

public class HJ80 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            TreeSet<Integer> set=new TreeSet<>();
            int a = sc.nextInt();
            for(int i=0;i<a;i++)
            {
                set.add(sc.nextInt());
            }
            int b = sc.nextInt();
            for(int i=0;i<b;i++)
            {
                set.add(sc.nextInt());
            }
            Iterator iter=set.iterator();
            while(iter.hasNext())
            {
                System.out.print(iter.next());
            }
            System.out.println();
        }
    }
}
