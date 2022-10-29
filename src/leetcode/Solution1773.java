package leetcode;

import java.util.List;

/**
 * 1773. 统计匹配检索规则的物品数量
 */
public class Solution1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int idx = -1, res = 0;
        if(ruleKey.equals("type")){
            idx = 0;
        }else if(ruleKey.equals("color")){
            idx = 1;
        }else {
            idx = 2;
        }
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).get(idx).equals(ruleValue)) res++;
        }
        return res;
    }
}
