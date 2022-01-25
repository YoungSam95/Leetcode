package yang;

import java.io.*;

public class test {

    public static void writeUser() throws IOException, ClassNotFoundException{
        try{
            User user = new User();
            user.setName("李寻欢");
            user.setAge(20);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/user.txt"));
            objectOutputStream.writeObject(user);
            System.out.println("序列化成功");
            objectOutputStream.close();
        } catch (Exception ex){
            System.out.println("write:" + ex.getMessage());
        }
    }
    public static void readUser() throws IOException,ClassNotFoundException{
        try{
            User user = null;
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:/user.txt"));
            user = (User) objectInputStream.readObject();
            System.out.println("反序列化成功");
            System.out.println("姓名："+user.getName() + "\n年龄：" + user.getAge());
        }catch(Exception ex){
            System.out.println("readUser:"+ ex.getMessage());
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        writeUser();
        readUser();

    }
}
