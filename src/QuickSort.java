public class QuickSort {

    public static void quickSort(int[] arr,int left,int right){
        if(left>right)return;
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
        quickSort(nums,0,5);
        for(int c : nums){
            System.out.println(c);
        }
    }
}
