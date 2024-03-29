package leetcode;

import java.util.Arrays;

/**
 * 473. 火柴拼正方形
 */
public class Solution473 {
    public boolean makesquare(int[] matchsticks) {
        int totalLen = 0;
        for(int num : matchsticks){
            totalLen += num;
        }
        if(totalLen == 0 || totalLen % 4 !=0) return false;
        int n = matchsticks.length;
        Arrays.sort(matchsticks);
        int len = totalLen / 4;
        int[] edges = new int[4];
        return dfs(n - 1,matchsticks,edges,len);
    }

    public boolean dfs(int index, int[] matchsticks, int[] edges,int len) {
        if(index == -1){
            return true;
        }
        for(int i = 0; i < 4; i++){
            edges[i] += matchsticks[index];
            if(edges[i] <= len && dfs(index - 1, matchsticks, edges,len)){
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }
    public static void main(String[] args){
        Solution473 s = new Solution473();
        int[] matchsticks = {3,3,3,3,4};
        System.out.println(s.makesquare(matchsticks));
    }
    /**
    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        //统计所有火柴的长度
        for (int num : matchsticks) {
            total += num;
        }
        //如果所有火柴的长度不是4的倍数，直接返回false
        if (total == 0 || (total & 3) != 0)
            return false;
        //先排序
        Arrays.sort(matchsticks);
        //回溯，从最长的火柴开始
        return backtrack(matchsticks, matchsticks.length - 1, total >> 2, new int[4]);
    }

    //index表示访问到当前火柴的位置，target表示正方形的边长，size是长度为4的数组，
    //分别保存正方形4个边的长度
    private boolean backtrack(int[] nums, int index, int target, int[] size) {
        if (index == -1) {
            //如果火柴都访问完了，并且size的4个边的长度都相等，说明是正方形，直接返回true，
            //否则返回false
            if (size[0] == size[1] && size[1] == size[2] && size[2] == size[3])
                return true;
            return false;
        }
        //到这一步说明火柴还没访问完
        for (int i = 0; i < size.length; i++) {
            //如果把当前火柴放到size[i]这个边上，他的长度大于target，我们直接跳过。或者
            // size[i] == size[i - 1]即上一个分支的值和当前分支的一样，上一个分支没有成功，
            //说明这个分支也不会成功，直接跳过即可。
            if (size[i] + nums[index] > target || (i > 0 && size[i] == size[i - 1])))
                continue;
            //如果当前火柴放到size[i]这个边上，长度不大于target，我们就放上面
            size[i] += nums[index];
            //然后在放下一个火柴，如果最终能变成正方形，直接返回true
            if (backtrack(nums, index - 1, target, size))
                return true;
            //如果当前火柴放到size[i]这个边上，最终不能构成正方形，我们就把他从
            //size[i]这个边上给移除，然后在试其他的边
            size[i] -= nums[index];
        }
        //如果不能构成正方形，直接返回false
        return false;
    }
     **/
}
