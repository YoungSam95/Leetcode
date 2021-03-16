import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * 解题思路：递归
 */
public class Solution46 {

    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new LinkedList<List<Integer>>();
        permute(nums,0,res);
        return res;
    }

    public static void permute(int[] nums,int start,List<List<Integer>> res){

        if(start == nums.length - 1){
            List<Integer> list = new LinkedList<Integer>();
            for(int i = 0;i < nums.length;i++){
                list.add(nums[i]);
            }
            res.add(list);
        }
        for(int i = start;i < nums.length;i++){
            swap(nums,start,i);
            permute(nums,start + 1,res);
            swap(nums,start,i);
        }
    }
    private static void swap(int[] nums, int i, int j){

        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args){

        int[] nums = {1,2,3,4};
        List<List<Integer>> res = permute(nums);
        System.out.print("[1,2,3,4]的全排列共有" + res.size() + "种，分别是");
        System.out.print(res);
    }
}
