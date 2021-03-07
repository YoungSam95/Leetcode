public class Solution215 {
    public static int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        return nums[nums.length - k];
    }

    public  static void quickSort(int[] arr,int left,int right) {

        if(left > right){
            return;
        }
        int L = left,R=right,base = arr[L];
        while(L<R){
            while(base<=arr[R] && L<R){
                R--;
            }
            arr[L] = arr[R];
            while(base>=arr[L] && L<R){
                L++;
            }
            arr[R] = arr[L];
        }
        arr[L] = base;
         quickSort(arr,left,L-1);
         quickSort(arr,R+1,right);

    }

    public static void main(String[] args){

        int[] nums = {3,2,1,5,6,4};
        int K = 2;
        System.out.println(findKthLargest(nums,K));
    }
}
