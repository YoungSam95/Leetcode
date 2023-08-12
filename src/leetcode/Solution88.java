package leetcode;

/**
 * 88.合并两个有序数组
 * 第二次
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail = nums1.length - 1;
        m--;
        n--;
        while(n >= 0){
            if(m < 0 || nums1[m] <= nums2[n]){
                nums1[tail--] = nums2[n--];
            }else{
                nums1[tail--] = nums1[m--];
            }
        }
    }
}
