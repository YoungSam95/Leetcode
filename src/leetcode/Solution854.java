package leetcode;

/**
 * 854. 相似度为 K 的字符串
 */
public class Solution854 {
    public int res = Integer.MAX_VALUE;

    public int kSimilarity(String s1, String s2) {
        return backtrack(s1.toCharArray(),s2.toCharArray(),0,0);
    }
    public int backtrack(char[] sc1, char[] sc2, int start, int curr){
        if(curr >= res) return res;
        if(start == sc1.length - 1) return res = Math.min(res,curr);
        for(int i = start; i < sc1.length; i++){
            if(sc1[i] != sc2[i]){
                for(int j = i + 1; j < sc2.length; j++){
                    if(sc2[j] == sc1[i] && sc2[j] != sc1[j]){
                        swap(sc2,i,j);//交换
                        backtrack(sc1,sc2,i + 1,curr + 1);
                        swap(sc2, i, j); // 回溯
                        if (sc2[i] == sc1[j]) break; // 如果sc1和sc2的i位于j位互为相等，那么就是最优交换
                    }
                }
                return res;
            }
        }
        return res = Math.min(curr, res);
    }
    public void swap(char[] sc, int i, int j){
        char temp = sc[i];
        sc[i] = sc[j];
        sc[j] = temp;
    }
    public static void main(String[] args){
        String s1 = "abc", s2 = "bca";
        System.out.println(new Solution854().kSimilarity(s1,s2));
    }
}
