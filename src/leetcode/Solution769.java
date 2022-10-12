package leetcode;

/**
 * 769. 最多能完成排序的块
 */
public class Solution769 {
    public int maxChunksToSorted(int[] arr) {
        int max = 0, res = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max,arr[i]);
            if(max == i) res++;
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr = {1,0,2,3,4};
        System.out.println(new Solution769().maxChunksToSorted(arr));
    }
}
