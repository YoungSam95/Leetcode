package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 464. 我能赢吗
 */
public class Solution464 {
    //记忆化的hashMap,用来记录选择了哪些树的情况，当前玩家的胜负；用以减少时间复杂度
    //例如先选2再选1的状态与先选1再选2的状态是相同的
    static Map<Integer, Boolean> memory = new HashMap<>();

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //如果加起来都不能超过的话，都不可能赢，return false
        if ((1+maxChoosableInteger)*maxChoosableInteger*0.5<desiredTotal){
            return false;
        }
        //否则的话递归判断，判断先手能不能赢，需要注意的是，先手从0开始
        return dfs(maxChoosableInteger,0,desiredTotal,0);
    }

    /**
     *
     * @param maxChoosableInteger 供选择的数
     * @param userNumbers  被选择的数，注意用二进制表示，如0010则表示2已经被选择，0001则表示1已被选择
     * @param desiredTotal  累计整数合需要超过的目标值
     * @param currentTotals  当前累计整数合
     * @return
     */
    public static boolean dfs(int maxChoosableInteger, int userNumbers, int desiredTotal, int currentTotals) {
        //如果未曾玩过这种场景，则做下列工作找出这种场景的答案
        if (!memory.containsKey(userNumbers)){
            boolean res = false;
            //循环遍历选择每个数的情况，如果循环完所有的情况，都赢不了，那么就输了，因此初始res是输
            for (int i = 0; i < maxChoosableInteger; i++) {
                //若这个数还没被选择，才往下做逻辑，否则进入下一轮循环(注意这里i是从0开始，所以判断的是第i+1个数的情况)
                //（userNumbers >> i) & 1 ：判断i+1是否已经被访问
                if (((userNumbers >> i) & 1) == 0) {
                    //如果选完能直接胜利，那么结果自然为true
                    if (i + 1 + currentTotals >= desiredTotal) {
                        res = true;
                        break;
                    }
                    //否则的话，递归判断，我选完后，对方选完是不是就输了；对方输了，我自然就赢了
                    //userNumbers | (1 << i)：把i+1标记为访问
                    if (!dfs(maxChoosableInteger, userNumbers | (1 << i), desiredTotal, currentTotals + i + 1)) {
                        res = true;
                        break;
                    }
                }
            }
            //把结果放入记忆化
            memory.put(userNumbers,res);
        }
        return memory.get(userNumbers);
    }
    public static void main(String[] args){
        int a = 7;
        int b = a >> 1;
        int c = b | 1 << 2;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
