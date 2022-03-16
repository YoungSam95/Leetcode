package huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class HJ98 {

    public static class Good{
        public String name;
        public int price;
        public int count;
        public Good(String name, int price, int count){
            this.name = name;
            this.price = price;
            this.count = count;
        }
        public Good(String name,int price){
            this.name = name;
            this.price = price;
        }
    }
    public static class Machine{
        public Good[] goods = {new Good("A1",2),new Good("A2",3),new Good("A3",4),
                               new Good("A4",5),new Good("A5",8),new Good("A6",6)};
        public int[] coinsValue = {1,2,5,10};
        public int[] coinsCount = new int[4];
        public int balance;
        /** r命令  初始化  **/
        public void initial(String str){
            String[] goodCount = str.split(" ")[1].split("-");
            String[] moneyCount = str.split(" ")[2].split("-");
            for(int i = 0; i < 6; i++){
                goods[i].count = Integer.valueOf(goodCount[i]);
            }
            for(int i = 0; i < 4; i++){
                coinsCount[i] = Integer.valueOf(moneyCount[i]);
            }
            System.out.println("S001:Initialization is successful");
        }
        /** p命令  投币  **/
        public void toubi(String str){
            if(!(str.split(" ")[1].equals("1") || str.split(" ")[1].equals("2") ||
                    str.split(" ")[1].equals("5") || str.split(" ")[1].equals("10"))){
                System.out.println("E002:Denomination error");
                return;
            }
            if(Integer.valueOf(str.split(" ")[1]) > 2 &&
                    coinsCount[0]+coinsCount[1]*2 < Integer.valueOf(str.split(" ")[1])){
                System.out.println("E003:Change is not enough, pay fail");
                return;
            }
            if(goods[0].count+goods[1].count+goods[2].count
                    +goods[3].count+goods[4].count+goods[5].count == 0){
                System.out.println("E005:All the goods sold out");
                return;
            }
           this.balance += Integer.valueOf(str.split(" ")[1]);
           if(Integer.valueOf(str.split(" ")[1]) == 1) coinsCount[0]++;
           if(Integer.valueOf(str.split(" ")[1]) == 2) coinsCount[1]++;
           if(Integer.valueOf(str.split(" ")[1]) == 5) coinsCount[2]++;
           if(Integer.valueOf(str.split(" ")[1]) == 10) coinsCount[3]++;
           System.out.println("S002:Pay success,balance="+this.balance);
        }
        /** b命令  购买物品  **/
        public void buy(String str){
            String sp = str.split(" ")[1];
            int index = -1;
            for(int i = 0; i < 6; i++){
                if(goods[i].name.equals(sp)){
                    index = i;
                    break;
                }
            }
            if(index == -1){
                System.out.println("E006:Goods does not exist");
                return;
            }
            if(goods[index].count == 0){
                System.out.println("E007:The goods sold out");
                return;
            }
            if(balance < goods[index].price){
                System.out.println("E008:Lack of balance");
                return;
            }
            this.balance -= goods[index].count;
            goods[index].count -= 1;
            System.out.println("S003:Buy success,balance=" + this.balance);
        }
        /** c命令  退币   **/
        public void tuibi(){
            if(this.balance == 0){
                System.out.println("E009:Work failure");
                return;
            }
            int tenNum = 0;
            int fiveNum = 0;
            int secNum = 0;
            int oneNum =0;
            while (this.balance >= 10 && coinsCount[3] > 0) {
                this.balance -= 10;
                coinsCount[3] -= 1;
                tenNum++;
            }
            while (this.balance >= 5 && coinsCount[2] > 0) {
                this.balance -= 5;
                coinsCount[2] -= 1;
                fiveNum++;
            }
            while (this.balance >= 2 && coinsCount[1] > 0) {
                this.balance -= 2;
                coinsCount[1] -= 1;
                secNum++;
            }
            while (this.balance >= 1 && coinsCount[0] > 0) {
                this.balance -= 1;
                coinsCount[0] -= 1;
                oneNum++;
            }
            this.balance=0;
            System.out.println("1 yuan coin number=" + oneNum);
            System.out.println("2 yuan coin number=" + secNum);
            System.out.println("5 yuan coin number=" + fiveNum);
            System.out.println("10 yuan coin number=" + tenNum);
        }
        /** q命令  查询类别  **/
        public void search(String str){
            if(str.length()!=3){
                System.out.println("E010:Parameter error");
                return;
            }
            if(str.charAt(2) == '1'){
                System.out.println("1 yuan coin number="+coinsCount[0]);
                System.out.println("2 yuan coin number="+coinsCount[1]);
                System.out.println("5 yuan coin number="+coinsCount[2]);
                System.out.println("10 yuan coin number="+coinsCount[03]);
                return;
            }
            if(str.charAt(2) == '0'){
                Good[] temp = new Good[6];
                for(int i = 0; i < 6; i++){
                    temp[i] = new Good(goods[i].name,goods[i].price,goods[i].count);
                }
                Arrays.sort(temp, new Comparator<Good>() {
                    @Override
                    public int compare(Good g1, Good g2) {
                        if(g1.count == g2.count){
                            return Integer.valueOf(g1.name.charAt(1)) - Integer.valueOf(g2.name.charAt(1));
                        }else{
                            return g2.count - g1.count;
                        }
                    }
                });
                for(Good g : temp){
                    System.out.println(g.name + " " + g.price + " " + g.count);
                }
                return;
            }
            System.out.println("E010:Parameter error");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Machine machine = new Machine();
        while(sc.hasNext()){
            String[] orders = sc.nextLine().split(";");
            for(String order : orders){
                if(order.charAt(0) == 'r') machine.initial(order);
                if(order.charAt(0) == 'p') machine.toubi(order);
                if(order.charAt(0) == 'b') machine.buy(order);
                if(order.charAt(0) == 'c') machine.tuibi();
                if(order.charAt(0) == 'q') machine.search(order);
            }
        }
    }
}
