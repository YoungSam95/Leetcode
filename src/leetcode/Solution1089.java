package leetcode;

/**
 * 1089. 复写零
 */
public class Solution1089 {
    public static void duplicateZeros(int[] arr) {
        /*for(int index = 0; index < arr.length;){
            if(arr[index] != 0){
                index++;
            }else{
                for(int i = arr.length - 1; i > index; i--){
                    arr[i] = arr[i - 1];
                }
                index += 2;
            }
        }*/
        /*int ans[]=new int[arr.length];
        for(int i=0,j=0;j<arr.length;i++,j++){
            if(arr[i]==0){j++;}
            else{ans[j]=arr[i];}
        }
        for(int i=0;i<arr.length;i++){arr[i]=ans[i];}*/
        int n = arr.length, i = 0, j = 0;
        while(j < n){
            if(arr[i] == 0) j++;
            i++;
            j++;
        }
        i--; j--;
        while(i >= 0){
            if(j < n) arr[j] = arr[i];
            if(arr[i] == 0) arr[--j] = 0;
            i--; j--;
        }
    }
    public static void main(String[] args){
        int[] arr = {0,0,0,0,0,0,0};
        duplicateZeros(arr);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
