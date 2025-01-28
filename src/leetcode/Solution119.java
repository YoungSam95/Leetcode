package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 第二次
 */
public class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);//每一行第一个数都是1;
        if(rowIndex == 0) return res;
        List<Integer> pre = new ArrayList<>();
        pre = getRow(rowIndex - 1);//递归计算上一行
        for(int i = 0; i < pre.size() - 1; i++){
            res.add(pre.get(i) + pre.get(i + 1));
        }
        res.add(1);//每一行最后一个数都是1;
        return res;
    }
}
