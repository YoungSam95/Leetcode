package huawei;

import java.util.*;

public class HJ80 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            TreeSet<Integer> set=new TreeSet<>();
            int a = in.nextInt();
            for(int i=0;i<a;i++)
            {
                set.add(in.nextInt());
            }
            int b = in.nextInt();
            for(int i=0;i<b;i++)
            {
                set.add(in.nextInt());
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
