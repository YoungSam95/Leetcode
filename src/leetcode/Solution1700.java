package leetcode;


/**
 * 1700. 无法吃午餐的学生数量
 */
public class Solution1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int s1 = 0;//喜欢方形的人数
        for(int student : students){
            s1 += student;
        }
        int s0 = students.length - s1;//喜欢圆形的人数
        for(int i = 0; i < sandwiches.length; i++){
            if(sandwiches[i] == 0 && s0 > 0){
                s0--;
            }else if(sandwiches[i] == 1 && s1 > 0){
                s1--;
            }else{
                break;
            }
        }
        return s0 + s1;
    }
}
