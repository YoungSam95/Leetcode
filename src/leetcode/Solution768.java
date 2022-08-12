package leetcode;

/**
 * 768. 最多能完成排序的块 II
 * 思路:对于当前下标，若右边最小值大于等于左边最大值，则可以在当前点进行分割
 */
public class Solution768 {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int[] leftMax = new int[arr.length];
        int[] rightMin = new int[arr.length];
        leftMax[0] = arr[0];
        rightMin[arr.length - 1] = arr[arr.length - 1];
        for(int i = 1; i < arr.length; i++){
            leftMax[i] = Math.max(arr[i],leftMax[i - 1]);
        }
        for(int i = arr.length - 2; i >= 0; i--){
            rightMin[i] = Math.min(arr[i],rightMin[i + 1]);
        }
        for(int i = 1; i < arr.length; i++){
            if(rightMin[i] >= leftMax[i - 1]){
                res++;
            }
        }
        return res;
    }
}
