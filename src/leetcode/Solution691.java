package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 691. 贴纸拼词
 */

public class Solution691 {
    public int minStickers(String[] stickers, String target) {
        char c[]=target.toCharArray();
        int count[][]=new int[stickers.length][26];
        for(int i=0;i<stickers.length;i++){
            for(char ch:stickers[i].toCharArray()){
                count[i][ch-'a']++;
            }
        }
        int ans[]=new int[1<<c.length];
        Arrays.fill(ans,1000);//先设为1000，之后遇到1000的位置说明不能拼成这个单词，直接返回-1
        ans[0]=0;
        for(int i=1;i<ans.length;i++){
            //先把mask中的字母转移到列表pos中:
            List<Integer> pos[]=new List[26];
            for(int j=0;j<c.length;j++){
                if((i&(1<<j))==0){continue;}
                int a=c[j]-'a';
                if(pos[a]==null){pos[a]=new ArrayList<>();}
                pos[a].add(j);
            }
            for(int j=0;j<stickers.length;j++){
                int mask=i;
                for(int p=0;p<26;p++){
                    if(pos[p]==null||count[j][p]==0){continue;}
                    int min=Math.min(pos[p].size(),count[j][p]);
                    for(int k=0;k<min;k++){mask-=(1<<pos[p].get(k));}
                }
                ans[i]=Math.min(ans[i],ans[mask]+1);
            }
        }
        return ans[(1<<c.length)-1]>=1000?-1:ans[(1<<c.length)-1];
    }
}
