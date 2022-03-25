package sort;

public class Sort {

    //冒泡排序
    public  static void bubbleSort(int[] arr){
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //选择排序
    public static void selectSort(int[] arr){

        for(int i = 0;i < arr.length - 1;i++){
            int min = i;
            for(int j = i + 1;j < arr.length;j++){
                if(arr[j] < arr[i]){
                    min = j;
                }
            }
            if(min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    //快速排序
    public static void quickSort(int[] arr,int left,int right){
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

    //归并排序
    public static void mergeSort(int[] arr){
        int[] temp = new int[arr.length];
        mergesort(arr,0,arr.length -1,temp);
    }
    public static void mergesort(int[] arr,int start,int end,int[] temp){
        if(start < end){
            int mid = (start + end)/2;
            mergesort(arr,start,mid,temp);
            mergesort(arr,mid + 1,end,temp);
            merge(arr,start,end,mid,temp);
        }
    }
    public static void merge(int[] arr,int start,int end,int mid,int[] temp){
        int L1 = start,L2 = mid + 1,t = 0;
        while(L1 <= mid && L2 <= end){
            if(arr[L1] <= arr[L2]){
                temp[t++] = arr[L1++];
            }else{
                temp[t++] = arr[L2++];
            }
        }
        while(L1<=mid){
            temp[t++] = arr[L1++];
        }
        while(L2<=end){
            temp[t++] = arr[L2++];
        }
        t = 0;
        while(start<=end){
            arr[start++] = temp[t++];
        }
    }

    public static void main(String[] args){
        int[] nums = {3,2,1,5,6,4};
        //quickSort(nums,0,5);
        //selectSort((nums));
        mergeSort(nums);
        for(int c : nums){
            System.out.println(c);
        }
    }
}
