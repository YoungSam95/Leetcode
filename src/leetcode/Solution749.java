package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 749. 隔离病毒
 */
public class Solution749 {
    int move[][]={{1,0},{-1,0},{0,1},{0,-1}};
    public int containVirus(int[][] isInfected) {
        boolean settled[][]=new boolean[55][55];
        //先把1的格子标记为不可变，表示的是这个格子会在某时变成1，即使后来又改为过0：
        for(int i=0;i<isInfected.length;i++){for(int j=0;j<isInfected[0].length;j++){if(isInfected[i][j]==1){settled[i][j]=true;}}}
        int ans=0;
        while(true){
            List<List<int[]>> blocks=findBlocks(isInfected);
            if(blocks.size()==0){break;}
            int idx=-1,max=-1,wall=-1;
            //先找到可以感染格子最多的连通块：
            for(int i=0;i<blocks.size();i++){
                int a[]=countBorders(blocks.get(i),isInfected,settled);
                if(max<a[1]){
                    max=a[1];
                    wall=a[0];
                    idx=i;
                }
            }
            if(wall==0){break;}
            ans+=wall;
            //标记被选定围住的那个连通块，全部设为0：
            List<int[]> locked=blocks.get(idx);
            for(int i=0;i<locked.size();i++){
                int a[]=locked.get(i);
                isInfected[a[0]][a[1]]=0;
            }
            //然后再把其他的连通块向外扩展1：
            for(int i=0;i<blocks.size();i++){
                if(i==idx){continue;}
                List<int[]> list=blocks.get(i);
                for(int j=0;j<list.size();j++){
                    int a[]=list.get(j);
                    for(int k=0;k<4;k++){
                        int x=a[0]+move[k][0],y=a[1]+move[k][1];
                        if(x>=0&&x<isInfected.length&&y>=0&&y<isInfected[0].length&&!settled[x][y]){
                            isInfected[x][y]=1;
                            settled[x][y]=true;
                        }
                    }
                }
            }
        }
        return ans;
    }
    int[] countBorders(List<int[]> list,int grid[][],boolean settled[][]){
        //计算连通块与0的相邻边数，以及相邻的0的数量
        int ans[]=new int[2];//边、0
        boolean cameBefore[][]=new boolean[55][55];
        for(int i=0;i<list.size();i++){
            int a[]=list.get(i);
            for(int j=0;j<4;j++){
                int x=a[0]+move[j][0],y=a[1]+move[j][1];
                if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]==0&&!settled[x][y]){
                    ans[0]++;
                    if(!cameBefore[x][y]){
                        cameBefore[x][y]=true;
                        ans[1]++;
                    }
                }
            }
        }
        return ans;
    }
    List<List<int[]>> findBlocks(int grid[][]){
        //提取每个病毒连区域
        boolean cameBefore[][]=new boolean[55][55];
        List<List<int[]>> ans=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1&&!cameBefore[i][j]){
                    cameBefore[i][j]=true;
                    List<int[]> list=new ArrayList<>();
                    list.add(new int[]{i,j});
                    for(int k=0;k<list.size();k++){
                        int a[]=list.get(k);
                        for(int p=0;p<4;p++){
                            int x=a[0]+move[p][0],y=a[1]+move[p][1];
                            if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]==1&&!cameBefore[x][y]){
                                list.add(new int[]{x,y});
                                cameBefore[x][y]=true;
                            }
                        }
                    }
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}
