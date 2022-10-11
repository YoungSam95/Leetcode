package leetcode;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 */
public class Solution817 {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int res = 0, count = 0;
        while(head != null){
            if(set.contains(head.val)){
                count++;
            }else{
                if(count != 0){
                    res++;
                    count = 0;
                }
            }
            head = head.next;
        }
        if(count != 0) res++;
        return res;
    }
}
