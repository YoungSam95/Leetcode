package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 */
public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);
        for(int i = 2; i <= numRows; i++){
            res.add(getNextRow(res.get(res.size()-1)));
        }
        return res;
    }

    public List<Integer> getNextRow(List<Integer> prev) {
        List<Integer> curr = new ArrayList<>();
        curr.add(1);
        for(int i = 0; i < prev.size() - 1; i++){
            curr.add(prev.get(i) + prev.get(i + 1));
        }
        curr.add(1);
        return curr;
    }

}
