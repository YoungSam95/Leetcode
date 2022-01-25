package yang;

import java.io.Serializable;

public class User implements Serializable {
    private static final Long serialVersionUID = 1L;
    private String userName;
    private int age;
    public void setName(String name){
        this.userName = name;
    }
    public String getName(){
        return userName;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
}
