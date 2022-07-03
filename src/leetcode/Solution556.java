package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 556. 下一个更大元素 III
 */
public class Solution556 {
    public int nextGreaterElement(int n) {
        List<Integer> num = new ArrayList<>();
        //按低位到高位取出
        while(n != 0){
            num.add(n % 10);
            n /= 10;
        }
        //找到第一个降序的位置
        int size = num.size(), index = -1;
        for(int i = 0; (i < size - 1) && (index == -1); i++){
            if(num.get(i + 1) < num.get(i)) index = i + 1;
        }
        //如果找不到，说明高位到低位非严格降序，不符合题意，返回-1
        if(index == -1) return -1;
        //交换比num[index]大的最小数
        for(int i = 0; i < index; i++){
            if(num.get(i) > num.get(index)){
                swap(num,i,index);
                break;
            }
        }
        //双指针交换，使得0-(index-1)非严格降序
        for(int l = 0, r = index - 1; l < r; l++, r--) swap(num,l,r);
        long ans = 0;
        for(int i = size - 1; i >= 0; i--) ans = ans * 10 +num.get(i);
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }
    public void swap(List<Integer> nums, int a, int b) {
        int c = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, c);
    }
    public static void main(String[] args){
        int n = 12;
        Solution556 s = new Solution556();
        System.out.println(s.nextGreaterElement(n));
    }
}
