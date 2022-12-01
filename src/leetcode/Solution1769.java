package leetcode;

/**
 * 1769. 移动所有球到每个盒子所需的最小操作数
 */
public class Solution1769 {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j != i && boxes.charAt(j) == '1'){
                    res[i] += Math.abs(i - j);
                }
            }
        }
        return res;
    }

    /**
     * O(n)解法
     */
    public int[] minOperations1(String boxes) {
        int left = boxes.charAt(0) - '0', right = 0, operations = 0;
        int n = boxes.length();
        for (int i = 1; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                right++;
                operations += i;
            }
        }
        int[] res = new int[n];
        res[0] = operations;
        for (int i = 1; i < n; i++) {
            operations += left - right;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
            res[i] = operations;
        }
        return res;
    }

    public static void main(String[] args){
        String boxes = "110";
        System.out.println(new Solution1769().minOperations(boxes));
    }
}
